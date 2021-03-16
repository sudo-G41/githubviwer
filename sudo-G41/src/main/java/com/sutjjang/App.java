package com.sutjjang;

import java.util.Scanner;

public class App{
	public static void main(String[] args){
		System.out.println("Hello World!");
		query q = new query("sudo-G41");
		String token;
		token = "ae0c6e4d086a4e823e5b114aca93f444f3030df9";
		GithubConnection g = new GithubConnection(token);
		g.setIO(q);
		Scanner sc = new Scanner(g.getInput());
		System.out.println(sc.nextLine());
	}
}