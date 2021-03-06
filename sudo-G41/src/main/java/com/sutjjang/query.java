package com.sutjjang;

import java.util.HashMap;

/**
* 쿼리문을 만들기  위한객체
* 최초 생성일 : 2021.02.18
* 최초 개발자 : sudo-G41(정수철)
* 마지막 수정일 : -
* 마지막 수정자 :sudo-G41
*/

public class query{
	private String login;
	private String name;
	private String formData, toData;
	private int repositories;
	private int contributions;
	private int fork;
	private int star;
	private int followers;
	private int following;
	private String toQuery;
	private String answer;
	
	public void setFormData(String formData) {
		this.formData = formData;
	}
	public void setToData(String toData) {
		this.toData = toData;
	}
	
	public query(String login){
		this.login = login;
		setFormData("2019-01-01T00:00:00Z");
		setToData("2020-01-01T00:00:00Z");
		this.toQuery = ""+
		"{\"query\" : "+
			"\"query {"+
				"user(login : \\\""+this.login+"\\\"){"+
					"login, name, "+
					"repos : repositories {"+
						"totalCount"+
					"}, "+
					"contributionsCollection(from : \\\""+this.formData+"\\\", to : \\\""+this.toData+"\\\"){"+
						"totalRepositoryContributions, "+
						"totalCommitContributions, "+
						"totalIssueContributions, "+
						"totalPullRequestContributions, "+
						"totalPullRequestReviewContributions "+
					"}, "+
					"forkstar : repositories(first :100, isFork : false){"+
						"totalCount, "+
						"nodes{"+
							"forkCount, "+
							"stargazerCount "+
						"}, "+
					"}, "+
					"followers{totalCount}, "+
					"following{totalCount}"+
				"}"+
			"}\""+
		"}";
		// this.toQuery = "{\"query\" : \" query{ viewer{name, login}} \"}";
	}
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the repositories
	 */
	public int getRepositories() {
		return repositories;
	}
	/**
	 * @return the contributions
	 */
	public int getContributions() {
		return contributions;
	}
	/**
	 * @return the fork
	 */
	public int getFork() {
		return fork;
	}
	/**
	 * @return the star
	 */
	public int getStar() {
		return star;
	}
	/**
	 * @return the followers
	 */
	public int getFollowers() {
		return followers;
	}
	/**
	 * @return the following
	 */
	public int getFollowing() {
		return following;
	}
	/**
	 * @return the toQuery
	 */
	public String getToQuery() {
		return toQuery;
	}
}