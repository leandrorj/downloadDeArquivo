package download_srf8_sbl63;

import java.io.IOException;



import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;


public class TestHtmlParse
{
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://www.google.com.br").get();
			Elements primeira_tag = doc.getElementsByTag("span").toggleClass("gb_ka gb_M gb_ka").html("Brasil");
			
			
			System.out.println(primeira_tag);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}