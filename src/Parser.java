import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.*;

public class Parser 
{
	public void remove_tags() throws Exception
	{
		String fileName="/home/miserysignals/kaam/output.txt";
		BufferedReader reader = new BufferedReader( new FileReader(fileName) );
		String line = reader.readLine();
		StringBuffer html=new StringBuffer();
		while(line!=null) 
		{
			line = reader.readLine();
			html.append(line);
			html.append("\n");
		}
				
		Document doc = Jsoup.parse(html.toString());
		//Elements links = doc.select("a[href]"); 
		
		//Extract meta tag description
		try
		{
		//get meta description content
		String description = doc.select("meta[name=description]").first().attr("content");
		System.out.println("Meta description : " + description);
	 
		//get meta keyword content
		String keywords = doc.select("meta[name=keywords]").first().attr("content");
		System.out.println("Meta keyword : " + keywords);
		}
		catch(Exception e)
		{
		System.out.println("No keywords");	
		}
		
		//Extract text from the webpage
		String noHTMLString=Jsoup.parse(html.toString()).text();
		File file = new File("/home/miserysignals/kaam/write.txt");
		Writer output = new BufferedWriter(new FileWriter(file));
		output.write(noHTMLString);
		output.close();
		
		
		//extract hyperlinks from the webpage		
		try
		{
		File file1 = new File("/home/miserysignals/kaam/link.txt");
		Writer output1 = new BufferedWriter(new FileWriter(file1));
		
		File file2 = new File("/home/miserysignals/kaam/link_text.txt");
		Writer output2 = new BufferedWriter(new FileWriter(file2));
				
		//Element content = doc.getElementById("content");
		//Elements links = content.getElementsByTag("a");
		Elements links = doc.select("a[href]");
		
		for (Element link : links) 
		{
		  String linkHref = link.attr("href");
		  output1.append(linkHref);
		  output1.append("\n");
		  
		  String linkText = link.text();
		  output2.append(linkText);
		  output2.append("\n");
		}
		output1.close();
		output2.close();
		                  
		}
		catch(Exception e)
		{
			System.out.println("No hyper-links");
		}

	}

}
