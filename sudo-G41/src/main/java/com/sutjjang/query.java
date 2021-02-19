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
	private int repositories;
	private int contributions;
	// privaDataata formdata, todata; //날짜 포멧으로 바꿀것
	private int fork;
	private int star;
	private int followers;
	private int following;
	private String toQuery;
	
	public query(String login){
		this.login = login;
		this.toQuery =  "{ user(login: \""+login+"\") { login name repos: repositories { totalCount } contributionsCollection(from: \"2019-01-01T00:00:00Z\", to: \"2019-12-31T00:00:00Z\") {       totalRepositoryContributions totalCommitContributions totalIssueContributions totalPullRequestContributions totalPullRequestReviewContributions } forkstar: repositories(first:100,isFork: false) { totalCount nodes { name forkCount stargazerCount } } followers { totalCount } following { totalCount } } }";
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