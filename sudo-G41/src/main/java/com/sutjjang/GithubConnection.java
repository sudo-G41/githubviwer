package com.sutjjang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/**
* 쿼리문을 만들기  위한객체
* 최초 생성일 : 2021.0
* 최초 개발자 : sudo-G41(정수철)
* 마지막 수정일 : 2021.02.20
* 마지막 수정자 :sudo-G41
*/
public class GithubConnection{
	private String http;
	private URL url = null;
	private HttpsURLConnection curl = null;
	private OutputStream os = null;
	private InputStream is = null;
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
			String token = "token 902f279723060686ee9fef94ba3851b4ad1609f5";
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
	
	public GithubConnection(String http, query q){
		String token = "token 902f279723060686ee9fef94ba3851b4ad1609f5";
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
		os = this.getOutput();
		try {
			os.write(this.getBytes(q));
			os.flush();
			System.out.println(curl.getResponseCode());
			is = getInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(is);
		String str = sc.nextLine();
		System.out.println(str);
		sc.close();
	}
	/**
	 * @return the curl
	 */
	public byte[] getBytes(query q) {
		String query = q.getToQuery();
		try {
			return query.getBytes("UTF-8");
		} catch (Exception e) {
			System.out.println("get변환 실패");
			return null;
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
	public OutputStream getOutput() {
		OutputStream os = null;
		if(this.curl == null){
			System.out.println("???????????? dksl dho???");
		}
		else{
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
		return os;
	}
	
	public InputStream getInput(){
		InputStream is = null;
		if(this.curl == null){
			System.out.println("wpqkf...");
		}
		try{
			is = this.curl.getInputStream();

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
