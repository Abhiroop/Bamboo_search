import java.io.BufferedReader;
import java.io.FileReader;

import org.knallgrau.utils.textcat.TextCategorizer;

public class Categorizer 
{
	public void Category() throws Exception
	{
		TextCategorizer guesser = new TextCategorizer();
		String fileName="/home/miserysignals/kaam/write.txt";
		BufferedReader reader = new BufferedReader( new FileReader(fileName) );
		String line = reader.readLine();
		StringBuffer text=new StringBuffer();
		while(line!=null) 
		{
			line = reader.readLine();
			text.append(line);
			text.append("\n");
		}
		String category = guesser.categorize((text.toString()));
		System.out.println(category);
	}

}
