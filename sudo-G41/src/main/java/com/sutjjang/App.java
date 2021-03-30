package com.sutjjang;

import java.util.Scanner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class App{
	public static void main(String[] args){
		System.out.println("Hello World!");
		// query q = new query("sudo-G41");
		// String token;
		// token = "ee24e56f8a31c2e66f372e31a6915d976c8abf73";
		// GithubConnection g = new GithubConnection(token);
		// g.setIO(q);
		// Scanner sc = new Scanner(g.getInput());
		// System.out.println(sc.nextLine());
		qwer qw = new qwer();
		// JCommander.newBuilder().addObject(qw).build().parse(args);
		System.out.println(qw.Help());
	}
}
