package com.kata.model.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author dcasanova
 */
@Entity
@Table(name = "kata")
public class Kata implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idkata")
	private Integer idkata;
	
	@Basic(optional = false)
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Basic(optional = false)
	@Column(name = "git_url")
	private String git_url;
	
	@JoinColumn(name = "category_idcategory", referencedColumnName = "idcategory")
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Category categoryIdcategory;
	
	@JoinColumn(name = "user_iduser", referencedColumnName = "iduser")
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User userIduser;

	public Kata() {
	}

	public Kata(Integer idkata) {
		this.idkata = idkata;
	}

	public Kata(Integer idkata, String title, String git_url) {
		this.idkata = idkata;
		this.title = title;
		this.git_url = git_url;
	}
	
	public Kata(String title, String git_url, String description) {
		this.title = title;
		this.git_url = git_url;
		this.description = description;
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

	public Category getCategoryIdcategory() {
		return categoryIdcategory;
	}

	public void setCategoryIdcategory(Category categoryIdcategory) {
		this.categoryIdcategory = categoryIdcategory;
	}

	public User getUserIduser() {
		return userIduser;
	}

	public void setUserIduser(User userIduser) {
		this.userIduser = userIduser;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idkata != null ? idkata.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Kata)) {
			return false;
		}
		Kata other = (Kata) object;
		if ((this.idkata == null && other.idkata != null)
				|| (this.idkata != null && !this.idkata.equals(other.idkata))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.danicasa.entity.Kata[ idkata=" + idkata + " ]";
	}

}
