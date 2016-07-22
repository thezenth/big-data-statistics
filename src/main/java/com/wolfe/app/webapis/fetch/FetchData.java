package webapis.fetch;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

//"http://apps.who.int/gho/athena/data/GHO/WHS3_48.json?profile=simple&filter=COUNTRY:*"

public class FetchData
{
    public static void main( String[] args )
    {
        //System.out.println(GetData("http://apps.who.int/gho/athena/data/GHO/WHS3_48.json?profile=simple&filter=COUNTRY:*"));
    }

    public static String GetData(String link)
    {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        String data = "";

        try {
            url = new URL(link);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                line = line.replace("\n", ""); //get rid of all the newlines - make parsing a tiny bit faster
                line = line.replace(" ", ""); //get rid of spaces
                data += line;
            }
        } catch (MalformedURLException mue) {
             mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        return data;
    }
}