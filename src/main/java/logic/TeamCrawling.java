package logic;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

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

public class TeamCrawling {
//	
//	 private static Queue<String> teamurl = new ConcurrentLinkedQueue<String>();
//	 
//	 public static void start(String url) throws ClientProtocolException, IOException {
//		 CloseableHttpClient httpclient =  HttpClients.createDefault(); // 创建httpclient实例
//		 HttpGet httpge = new HttpGet(url);
//		 CloseableHttpResponse response = httpclient.execute(httpge);//执行get请求
//		 HttpEntity entity = response.getEntity();
//		 String content = EntityUtils.toString(entity);
//		 response.close();
//		 Document doc = Jsoup.parse(content); // 
//		 Element teamlist = doc.getElementsByClass("nav-team").get(0);
//		Elements list = teamlist.getElementsByClass("team-list");
//		for(Element apart:list) {
//			Elements lls = apart.select("a");
//			for(Element ll:lls) {
//				teamurl.add(ll.absUrl("href"));
//			}
//		}
//		 System.out.println(teamurl.size());
//	 }
//    public static void main(String[] args) {
//    	try {
//			TeamCrawling.start("http://china.nba.com/teamindex/");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
