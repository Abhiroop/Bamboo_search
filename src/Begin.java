
public class Begin 
{
	public static void main(String[]args)throws Exception
	{
		Start x=new Start();
		x.accept();
		Parser y=new Parser();
		y.remove_tags();
		StopWordRemoval a=new StopWordRemoval();
		a.modify();
		Indexer z=new Indexer();
		z.word_count();
					
	}
}
