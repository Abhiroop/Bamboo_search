public class PythonCaller 
{
	public void callPython() throws Exception
	{

		String pythonScriptPath = "/home/abhiroop/Java_Workspace/Bamboo_Search/stopwordremoval.py";
		String[] cmd = new String[2];
		cmd[0] = "python";
		cmd[1] = pythonScriptPath;
 
		Runtime rt = Runtime.getRuntime();
		rt.exec(cmd);
 	}
}