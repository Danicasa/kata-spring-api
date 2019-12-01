package com.kata.model.response;

import java.io.Serializable;

/**
 *
 * @author dcasanova
 */
public class UserResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer iduser;
    private String email;
    private String name;
    private String git_url;

    public UserResponse() {
    }
    
    public UserResponse(Integer iduser) {
        this.iduser = iduser;
    }

    public UserResponse(Integer iduser, String email, String name, String git_url) {
        this.iduser = iduser;
        this.email = email;
        this.name = name;
        this.git_url = git_url;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGitUrl() {
        return git_url;
    }

    public void setGitUrl(String gitUrl) {
        this.git_url = gitUrl;
    }
    
}
