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
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategory")
    private Integer idcategory;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryIdcategory")
    private Collection<Kata> kataCollection;

    public Category() {
    }

    public Category(Integer idcategory) {
        this.idcategory = idcategory;
    }

    public Category(Integer idcategory, String description) {
        this.idcategory = idcategory;
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
        hash += (idcategory != null ? idcategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.idcategory == null && other.idcategory != null) || (this.idcategory != null && !this.idcategory.equals(other.idcategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.danicasa.kata.Category[ idcategory=" + idcategory + " ]";
    }
    
}
