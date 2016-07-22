package com.wolfe.app;

import webapis.fetch.FetchData;


public class Main
{
    public static void main( String[] args )
    {
        System.out.println(
            FetchData.GetData("http://apps.who.int/gho/athena/data/GHO/WHS3_48.json?profile=simple&filter=COUNTRY:*")
        );
    }
}
