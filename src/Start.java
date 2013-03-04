import java.io.*;
import java.net.*;
import org.apache.commons.codec.binary.Base64;

public class Start {
    public void accept() throws Exception 
    {
        // Configure proxy ...
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", "10.1.9.36");
        System.setProperty("http.proxyPort", "8080");
        //System.setProperty("http.proxyType", "4");
        String proxyUser = "f2010535",
           proxyPassword = "starwars";
 
        // Open URL ...
        URL url = new URL("http://databases.about.com/");
 
        URLConnection con = url.openConnection();
        
        //proxy user and password
        String encoded = new String(Base64.encodeBase64((proxyUser+":"+proxyPassword).getBytes()));
        
        con.setRequestProperty("Proxy-Authorization","Basic " + encoded);
        
        BufferedReader in = new BufferedReader (new InputStreamReader (con.getInputStream ()));
 
        // Read it ...
        String inputLine;
        PrintWriter out = new PrintWriter(new FileWriter("/home/miserysignals/kaam/output.txt"), true);
        while ((inputLine = in.readLine()) != null)
        {
          out.append(inputLine);
          out.append("\n");
        }
        out.close();
 
        in.close();
    }
}