package com.sutjjang;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
* 쿼리문을 만들기  위한객체
* 최초 생성일 : 2021.02.19
* 최초 개발자 : sudo-G41(정수철)
* 마지막 수정일 : 2021.02.20
* 마지막 수정자 :sudo-G41
*/

public class connection{
	private String http;
	private URL url = null;
	private HttpsURLConnection curl = null;
	public connection(){
		
	}
	public connection(String http){
		this.http = http;
		try{
			this.url = new URL(http);
			curl = (HttpsURLConnection)url.openConnection();
			// curl.setHostnameVerifier()
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}