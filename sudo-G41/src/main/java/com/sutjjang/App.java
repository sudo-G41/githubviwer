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
		query q = new query("sudo-G41");
        System.out.println(q.getToQuery());
        GithubConnection github = new GithubConnection("https://api.github.com/graphql", q);
    }
}
