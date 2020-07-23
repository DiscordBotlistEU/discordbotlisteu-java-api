package ink.discordbotlist.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class DiscordBotlistApi {
	
	private String token;
	protected String dbl = "[Discord-Botlist.eu] ";
	
	public DiscordBotlistApi(String token) {
		this.token = token;
	}
	
	private String getToken() {
		return token;
	}
	
	public void post(int servercount) {
    	try {
    		
    		System.out.println(dbl + "Trying to post the servercount...");
    		URL url = new URL("https://www.discord-botlist.eu/api/setservers/" + getToken() + "/" + servercount);
        	URLConnection con = url.openConnection();
        	HttpURLConnection http = (HttpURLConnection)con;
        	con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
        	http.setDoOutput(true);
        	
        	if (http.getResponseCode() == 200) {
        		System.out.println(dbl + "Servercount (" + servercount + " servers) posted!");
        	} else if (http.getResponseCode() == 401 || http.getResponseCode() == 403) {
        		System.out.println(dbl + "An error occured while trying to post your servercount: Unauthorized Token");
        	} else if (http.getResponseCode() == 500) {
        		System.out.println(dbl + "An error occured while trying to post your servercount: Internal Server error.");
        	} else {
        		System.out.println(dbl + "An error occured while trying to post your servercount: Unknown (Responsecode: " + http.getResponseCode() + ")");
        	}
        	
    	}catch (IOException e) {
		    e.printStackTrace();
		    System.out.println("This should not happen. Please report this error to Inkception#1508 on discord.");
		}
	}

}
