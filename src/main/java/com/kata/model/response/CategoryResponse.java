package com.kata.model.response;

import java.io.Serializable;

public class CategoryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idcategory;
	private String description;
	
    public CategoryResponse() {
    	
    }
    
    public CategoryResponse(Integer idCategory, String description) {
    	this.idcategory = idCategory;
    	this.description = description;
    }
    
    public Integer getIdcategory() {
		return idcategory;
	}

	public void setIdcategory(Integer idcategory) {
		this.idcategory = idcategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
       
}
