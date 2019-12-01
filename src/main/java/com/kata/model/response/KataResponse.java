package com.kata.model.response;

import java.io.Serializable;

public class KataResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idkata;
	private String title;
	private String description;
	private String git_url;
	private CategoryResponse category;
	private UserResponse user;

	public KataResponse() {
	}

	public KataResponse(Integer idkata) {
		this.idkata = idkata;
	}

	public KataResponse(Integer idkata, String title, String git_url) {
		this.idkata = idkata;
		this.title = title;
		this.git_url = git_url;
	}

	public Integer getIdkata() {
		return idkata;
	}

	public void setIdkata(Integer idkata) {
		this.idkata = idkata;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGitUrl() {
		return git_url;
	}

	public void setGitUrl(String git_url) {
		this.git_url = git_url;
	}

	public CategoryResponse getCategoryIdcategory() {
		return category;
	}

	public void setCategoryIdcategory(CategoryResponse category) {
		this.category = category;
	}

	public UserResponse getUserIduser() {
		return user;
	}

	public void setUserIduser(UserResponse user) {
		this.user = user;
	}

}
