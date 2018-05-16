package download_srf8_sbl63;

import java.io.IOException;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestHtmlParse {
	public static void main(String[] args) {
		
		try {
			Document doc = Jsoup.connect("http://localhost:8080/2018/Maio/").get();
			// Elements primeira_tag = doc.getElementsByTag("span").toggleClass("gb_ka gb_M
			// gb_ka").html("Brasil");

			Elements elements = doc.select("table");
			Elements rows = elements.get(0).select("tr");
			String linkDoArquivo = null;
			String dataCompleta = null;

			for (Element row : rows) {

				if (row.select("td").size() == 3) {
					linkDoArquivo = row.select("td").get(0).text();
					// String port = row.select("td").get(1).text();
					dataCompleta = row.select("td").get(2).text();
					
				}
				
			}
			System.out.println(linkDoArquivo + "  -----------   " + dataCompleta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}