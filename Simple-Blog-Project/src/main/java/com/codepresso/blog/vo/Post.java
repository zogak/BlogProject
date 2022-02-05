package com.codepresso.blog.vo;

import java.util.Date;


public class Post {

	private Long id;

	private String userName;

	private String title;

	private String postContent;

	private Date regDate;

	private Date updtDate;
	
	public Post() {
		
	}
	
	public Post(Long id, String title, String postContent) {
		this.id = id;
		this.title = title;
		this.postContent = postContent;
	}
	
	public Post(String userName, String title, String postContent) {
		this.userName = userName;
		this.title = title;
		this.postContent = postContent;
		this.regDate = new Date();
		this.updtDate = new Date();
	}

	public Post(Long id, String userName, String title, String postContent) {
		this.id = id;
		this.userName = userName;
		this.title = title;
		this.postContent = postContent;
		this.regDate = new Date();
		this.updtDate = new Date();
	}

	public Post(Long id, String userName, String title, String postContent, Date regDate, Date updtDate) {
		this.id = id;
		this.userName = userName;
		this.title = title;
		this.postContent = postContent;
		this.regDate = regDate;
		this.updtDate = updtDate;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdtDate() {
		return updtDate;
	}

	public void setUpdtDate(Date updtDate) {
		this.updtDate = updtDate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nid : ").append(id).append("\n");
		sb.append("user : ").append(userName).append("\n");
		sb.append("title : ").append(title).append("\n");
		sb.append("postContent : ").append(postContent).append("\n");
		
		return sb.toString();
	}
}
