package com.codepresso.blog.vo;


import java.util.Date;

public class UserComment {
	

	private Long id;

	private Long postId;

	private String userName;

	private String content;

	private Date regDate;
	
	public UserComment() {
	}
	
	public UserComment(Long postId, String userName, String content) {
		this.postId = postId;
		this.userName = userName;
		this.content = content;
		this.regDate = new Date();
	}

	public UserComment(Long id, String content) {
		this.id = id;
		this.content = content;
		this.regDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
