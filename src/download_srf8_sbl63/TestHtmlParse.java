package download_srf8_sbl63;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;


public class TestHtmlParse
{
	Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
	log(doc.title());
	Elements newsHeadlines = doc.select("#mp-itn b a");
	for (Element headline : newsHeadlines) {
	  log("%s\n\t%s", 
	    headline.attr("title"), headline.absUrl("href"));
	}
   
   
}