package com.sutjjang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
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
	private String token = "token ";
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
			String token = "token 747d253418a08b68cb44ebacfd242815608a5205";
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
		this.token = "token 747d253418a08b68cb44ebacfd242815608a5205";
		try{
			System.out.println(http);
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
			this.curl.setRequestProperty("Content-Type", "application/json; UTF-8");
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

	public GithubConnection(String token){
		this.token = "token "+token;
		this.http = "https://api.github.com/graphql";
		if(setCurl()){
			System.out.println("Conncetion is null... 왜???");
			return;//커넥션이 왜인지 모르지만 연결실패해서 망했다는걸 이야기 합니다. 왜??? 그래서 일단 멈추고 볼려고 넣었습니다.. 왜??? 진짜 왜 그러는데???
		}
	}

	/**
	 * set Curl
	 * HttpsConnection을 설정하는 그런곳 허허
	 * @return 성공여부 실패하면 false를 리턴합니다.
	 */
	public boolean setCurl() {
		try{
			this.url = new URL(this.http);
			this.curl = (HttpsURLConnection)url.openConnection();
			this.curl.setRequestMethod("POST");
			this.curl.setRequestProperty("Content-Type", "application/json; UTF-8");
			this.curl.setRequestProperty("Authorization",this.token);
			this.curl.setDoInput(true);
			this.curl.setDoOutput(true);
			this.curl.connect();
		}
		catch(UnsupportedEncodingException e){
			System.out.println("에러 뻥뻥!!\ngithubconnection.java "+" line : "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"\n Method : "+Thread.currentThread().getStackTrace()[1].getMethodName());
			e.printStackTrace();
		}
		catch(MalformedURLException e){
			System.out.println("에러 뻥뻥!!\ngithubconnection.java "+" line : "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"\n Method : "+Thread.currentThread().getStackTrace()[1].getMethodName());
			e.printStackTrace();
		}
		catch(ProtocolException e){
			System.out.println("에러 뻥뻥!!\ngithubconnection.java "+" line : "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"\n Method : "+Thread.currentThread().getStackTrace()[1].getMethodName());
			e.printStackTrace();
		}
		catch(IOException e){
			System.out.println("에러 뻥뻥!!\ngithubconnection.java "+" line : "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"\n Method : "+Thread.currentThread().getStackTrace()[1].getMethodName());
			e.printStackTrace();
		}
		return this.curl == null? true: false;
	}

	/**
	 * set IO
	 * InputStream과 OutputStream을 설정
	 */
	public Scanner setIO(query q) {
		try{
			this.os = this.getOutput();
			this.os.write(this.getBytes(q));
			this.os.flush();
		}
		catch(IOException e){
			System.out.println("에러 뻥뻥!!\ngithubconnection.java "+" line : "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"\n Method : "+Thread.currentThread().getStackTrace()[1].getMethodName());
		}
		return new Scanner(getInput());
	}

	/**
	 * @return the Bytes
	 */
	public byte[] getBytes(query q) {
		String query = q.getToQuery();
		try {
			return query.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
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
	 * @return the OutputStream
	 * Post로 보내기 위한 outputStream을 생성하기 위한 메소드입니다.
	 */
	public OutputStream getOutput() {
		OutputStream os = null;
		if(this.curl == null){
			System.out.println("???????????? 이걸????? 왜?????????");
		}
		// else{
		// 	try{
		// 		System.out.println(this.curl.getOutputStream().getClass());
		// 	}
		// 	catch(IOException e){
		// 		e.printStackTrace();
		// 	}
		// }
		try{
			os = this.curl.getOutputStream();
		}
		catch(IOException e){
			System.out.println("에러 뻥뻥!!\ngithubconnection.java "+" line : "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"\n Method : "+Thread.currentThread().getStackTrace()[1].getMethodName());
			e.printStackTrace();
		}
		catch(NullPointerException e){
			System.out.println("에러 뻥뻥!!\ngithubconnection.java "+" line : "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"\n Method : "+Thread.currentThread().getStackTrace()[1].getMethodName());
			e.printStackTrace();
		}
		return os;
	}

	/**
	 * @return the InputStream
	 * Post로 보내고 받은 리턴을 받기위한 InputStream을 리턴받는다.
	 */
	public InputStream getInput(){
		InputStream is = null;
		if(this.curl == null){
			System.out.println("wpqkf...");
		}
		try{
			is = this.curl.getInputStream();
		}
		catch(IOException e){
			System.out.println("");
			System.out.println("에러 뻥뻥!!\ngithubconnection.java "+" line : "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"\n Method : "+Thread.currentThread().getStackTrace()[1].getMethodName());
			e.printStackTrace();
		}
		if(is == null){
			System.out.println("이건 망했다...");
		}
		return is;
	}
}
