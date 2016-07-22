package com.wolfe.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;

/**
 * Hello world!
 *
*/
public class Main
{
    public static void main( String[] args )
    {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            url = new URL("http://apps.who.int/gho/athena/data/GHO/WHS3_48.json?profile=simple&filter=COUNTRY:*");
            is = url.openStream(); //throws an IOException - we haven't yet told the computer how to handle the IO
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException mue) { //URL is somehow wrong - like if it started with hhtp:// instead of http://
             mue.printStackTrace();
        } catch (IOException ioe) { //IO = input/output, so generally something is wrong with the server's mechanism to actually give us data
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


    }
}
