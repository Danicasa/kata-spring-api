package com.kata.model.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dcasanova
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduser")
    private Integer iduser;
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "git_url")
    private String git_url;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIduser")
    private Collection<Kata> kataCollection;

    public User() {
    }

    public User(Integer iduser) {
        this.iduser = iduser;
    }

    public User(Integer iduser, String email, String name, String git_url) {
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

    @XmlTransient
    public Collection<Kata> getKataCollection() {
        return kataCollection;
    }

    public void setKataCollection(Collection<Kata> kataCollection) {
        this.kataCollection = kataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.User[ iduser=" + iduser + " ]";
    }
    
}
