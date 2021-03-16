package com.sutjjang;

import java.util.Scanner;

public class App{
	public static void main(String[] args){
		System.out.println("Hello World!");
		query q = new query("sudo-G41");
		String token;
		token = "95be2764e70aef677d04c4a7d261128cf99a0c4d";
		GithubConnection g = new GithubConnection(token);
		g.setIO(q);
		Scanner sc = new Scanner(g.getInput());
		System.out.println(sc.nextLine());
	}
}