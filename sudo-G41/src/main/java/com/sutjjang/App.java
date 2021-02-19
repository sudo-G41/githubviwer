package com.sutjjang;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
		query q = new query("sutjjang");
		System.out.println(q.getToQuery());
    }
}
