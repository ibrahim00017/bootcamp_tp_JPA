/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ibrahim
 */
@Entity
@Table(name="tp_indicateurQuantitatif")
public class IndicateurQuantitatif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length=45)
    private String nom;
    
    @Column(length=45)
    private String propriete;
    
    @Column(length=45)
    private String valeur;
    
    @OneToMany(mappedBy="tp_indicateurQuantitatif",cascade=CascadeType.PERSIST)
    private List<IndicateurPerformance> indicateurPerformance = new ArrayList<IndicateurPerformance>();

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPropriete() {
        return propriete;
    }

    public void setPropriete(String propriete) {
        this.propriete = propriete;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public List<IndicateurPerformance> getIndicateurPerformance() {
        return indicateurPerformance;
    }

    public void setIndicateurPerformance(List<IndicateurPerformance> indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndicateurQuantitatif)) {
            return false;
        }
        IndicateurQuantitatif other = (IndicateurQuantitatif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.IndicateurQuantitatif[ id=" + id + " ]";
    }
    
}
