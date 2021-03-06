package com.sutjjang;

import java.util.Scanner;

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
        // System.out.println(q.getToQuery());
        String graphQl = "https://api.github.com/graphql";
        String token = "807669579e51a96bbffba11cff235553300dbf0e";
        // GithubConnection github = new GithubConnection("https://api.github.com/graphql", q);
        GithubConnection git = new GithubConnection(graphQl, token);
        git.setIO(q);
        Scanner sc = new Scanner(git.getInput());
        System.out.println(sc.nextLine());
    }
}
