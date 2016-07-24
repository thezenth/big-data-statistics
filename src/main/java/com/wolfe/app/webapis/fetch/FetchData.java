package webapis.fetch;

//Getting the data from the internet
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

//JSON parsing
import javax.json.*;

import webapis.models.WHO.Survey;

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
        String line;
        String data = "";

        System.out.println("Attempting to get data from " + link + "...");

        try {
            url = new URL(link);
            is = url.openStream();

            JsonReader rdr = Json.createReader(is);
            JsonObject obj = rdr.readObject();
            JsonArray results = obj.getJsonArray("fact");

            for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                Survey newSurvey = new Survey();
                newSurvey.year = Integer.parseInt(result.getJsonObject("dim").getString("YEAR"));
                newSurvey.value = Integer.parseInt(
                    result.getString("Value").replace(" ", "")
                );
                newSurvey.country = result.getJsonObject("dim").getString("COUNTRY");
                newSurvey.region = result.getJsonObject("dim").getString("REGION");
                newSurvey.gho = result.getJsonObject("dim").getString("GHO");
                newSurvey.publishState = result.getJsonObject("dim").getString("PUBLISHSTATE");

                newSurvey.PrintAll();
            }

            //br = new BufferedReader(new InputStreamReader(is));

            /*while ((line = br.readLine()) != null) {
                line = line.replace("\n", ""); //get rid of all the newlines - make parsing a tiny bit faster
                line = line.replace(" ", ""); //get rid of spaces
                data += line;
            }*/
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
