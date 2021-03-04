package com.sutjjang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/**
* 쿼리문을 만들기  위한객체
* 최초 생성일 : 2021.02.19
* 최초 개발자 : sudo-G41(정수철)
* 마지막 수정일 : 2021.02.20
* 마지막 수정자 :sudo-G41
*/

public class GithubConnection{
	private String http;
	private URL url = null;
	private HttpsURLConnection curl = null;
	//테스트용restAPI 사용한 것
	public GithubConnection(){
		this.http = "https://api.github.com/users/sudo-G41";
		try{
			this.url = new URL(this.http);
			if(this.url == null){
				System.out.println("url is null");
			}
			else{
				System.out.println(url.getClass());
			}
			String token = "token ccdb2b758c9907c911eba26ffbd889343c42b633";
			this.curl = (HttpsURLConnection)url.openConnection();
			// if(this.curl==null){
			// 	System.out.println("curl is null");
			// }
			// else{
			// 	System.out.println(curl.getClass());
			// }
			this.curl.setRequestMethod("GET");
			this.curl.addRequestProperty("Authorization", token);
			this.curl.setDoOutput(true);
			this.curl.setDoInput(true);
		}
		catch(Exception e){
			System.out.println(e);
		}
		// System.out.println(this.curl.toString());
		try{
			System.out.println(this.curl.getInputStream().toString());
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public GithubConnection(String http, String token){
		token = "token "+token;
		try{
			this.http = URLEncoder.encode(http,"UTF-8");
			this.url = new URL(http);
			this.curl = (HttpsURLConnection)url.openConnection();
			if(this.curl == null||url==null){
				System.out.println("wpqkfskrkenlwu");
			}
			this.curl.setHostnameVerifier(new HostnameVerifier(){
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return false;
				}
			});
			this.curl.setRequestMethod("POST");
			this.curl.setRequestProperty("Content-Type", "application/json; U-8");
			this.curl.setRequestProperty("Authorization",token);
			this.curl.setDoInput(true);
			this.curl.setDoOutput(true);
			this.curl.connect();
		}
		catch(Exception e){
			System.out.println("connection.java 27line");
			System.out.println(e);
		}
	}
	/**
	 * @return the curl
	 */
	public HttpsURLConnection getCurl() {
		return this.curl;
	}
	/**
	 * @return the curl
	 */
	public OutputStream getoutput() {
		OutputStream os = null;
		if(this.curl == null){
			System.out.println("???????????? dksl dho???");
		}
		else{
			System.out.println("여긴 됩니다.");
			try{
				System.out.println(this.curl.getOutputStream().getClass());
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		try{
			os = this.curl.getOutputStream();
		}
		catch(IOException e){
			System.out.print("git.java 85 :");
			e.printStackTrace();
		}
		catch(NullPointerException e){
			System.out.print("git.java 89 :");
			e.printStackTrace();
		}
		System.out.println("\n\n================================\n" + os.getClass()+" "+os.toString()+"\n================================\n\n");
		return os;
	}
	
	public InputStream getInputStream(){
		InputStream is = null;
		if(this.curl == null){
			System.out.println("wpqkf...");
		}
		try{
			is = this.curl.getInputStream();
			System.out.println("133!!!\n\n\n\n");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		if(is == null){
			System.out.println("이건 망했다...");
		}
		return is;
	}
}