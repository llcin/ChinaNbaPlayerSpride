package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Player;

/**
 * 根据传入的队伍名称组成url 获取所有运动员的json数据，解析后返回List里面为player对象
 * 
 * @author pc
 *
 */
public class PlayerCrawling {

	static class SingletonHolder {
		static PlayerCrawling instance = new PlayerCrawling();
	}

	public static PlayerCrawling getInstance() {
		return SingletonHolder.instance;
	}

	private static String base = "http://china.nba.com/static/data/team/playerstats_";

	private static String json = ".json";
	/**
	 * 可以根据没一个线程创建一个CloseableHttpClient 对象
	 */
	final ThreadLocal<CloseableHttpClient> httpclient = new ThreadLocal<CloseableHttpClient>() {
		@Override
		protected CloseableHttpClient initialValue() {
			return HttpClients.createDefault();
		}
	};

	/**
	 * 
	 * @param teamname 队伍名称
	 * @return 一个队伍中所有的 player
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public List<Player> start(String teamname) throws ClientProtocolException, IOException {

		String url = base + teamname + json;
		HttpGet httpge = new HttpGet(url);
		CloseableHttpResponse response = httpclient.get().execute(httpge);// 执行get请求
		HttpEntity entity = response.getEntity();
		String contentplayer = EntityUtils.toString(entity, "utf-8");// toString(entity);
		response.close();
		Document docplayer = Jsoup.parseBodyFragment(contentplayer);
		Element s = docplayer.body();
		String jsoN = s.text().toString();
		JSONObject jsonObject = new JSONObject(jsoN);
		JSONObject jsonObject2 = (JSONObject) jsonObject.get("payload");
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get("team");
		JSONArray data = jsonObject3.getJSONArray("players");
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < data.length(); i++) {
			ObjectMapper mapper = new ObjectMapper();
			Object obj = ((JSONObject) data.get(i)).get("profile");
			String json = obj.toString();
			Player p = mapper.readValue(json, Player.class);
			p.setTeam(teamname);
			players.add(p);
		}
		return players;
	}
	// System.out.println(data);
}
