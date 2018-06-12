package logic;

import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import bean.Player;
public class TeamPlayerCraling {

	/**
	 * url = base+team+json;http://china.nba.com/static/data/team/playerstats_mavericks.json
	 */
	private static String Starturl = "http://china.nba.com";
	
	public static Queue<String> team = new ConcurrentLinkedQueue<String>();
	
	//public static ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
	
	public static  String getTeamname() {
		
		
		return team.poll();
	}
	
	public  void startcrawling() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建httpclient实例
		HttpGet httpge = new HttpGet(Starturl);
		CloseableHttpResponse response = httpclient.execute(httpge);// 执行get请求
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity);
		Document doc = Jsoup.parse(content); //
		Elements plays = doc.getElementsByClass("nav-team");
		Element teamlist = doc.getElementsByClass("nav-team").get(0);
		Elements list = teamlist.getElementsByClass("team-list");
		for(Element apart:list) {
			Elements lls = apart.select("a");
			for(Element ll:lls) {
				String teamname = ll.absUrl("href");
				team.add(teamname.substring(21, teamname.length()-1));
			}
		}
		System.out.println(team.size());
		
	}

	public  void start() throws ClientProtocolException, IOException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		final CountDownLatch cl = new CountDownLatch(5);
		Runnable Runnable = new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				String teamname = getTeamname();
				while(teamname!=null&&teamname.length()>0) {
					try {
						PlayerCrawling playerCrawling =new PlayerCrawling();
						List<Player> player =playerCrawling.start(teamname);
						System.out.println(player);
					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					teamname = getTeamname();
					Thread.yield();
					
				}
				cl.countDown();
			}
		};
		for(int i =0;i<5;i++) {
			executorService.execute(Runnable);
		}
		cl.await();
		executorService.shutdown();

	}
	public static void main(String[] args) throws ClientProtocolException, IOException, InterruptedException {
		long starttime = System.currentTimeMillis();
		TeamPlayerCraling helloWorld=new TeamPlayerCraling();
		
		helloWorld.startcrawling() ;
		helloWorld.start();
		System.out.println("共耗时="+(System.currentTimeMillis()-starttime)+"ms");
	}
}
