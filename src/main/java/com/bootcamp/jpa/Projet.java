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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ibrahim
 */
@Entity(name="tp_projet")
public class Projet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length=45)
    private String nom;
    
    @Column(length=45)
    private String objectif;
    
    @OneToOne
    private IndicateurPerformance indicateurPerformance;
    
    @OneToMany(mappedBy="programme",cascade=CascadeType.PERSIST)
    private List<Programme> programme = new ArrayList<Programme>();
    
    @ManyToMany(mappedBy="projets")
    private List<Bailleur> bailleurs = new ArrayList<Bailleur>();

    public List<Programme> getProgramme() {
        return programme;
    }

    public void setProgramme(List<Programme> programme) {
        this.programme = programme;
    }

    public List<Bailleur> getBailleurs() {
        return bailleurs;
    }

    public void setBailleurs(List<Bailleur> bailleurs) {
        this.bailleurs = bailleurs;
    }
    
    @ManyToMany(mappedBy="projets")
    private List<Beneficiaire> beneficiaires = new ArrayList<Beneficiaire>();

    public List<Beneficiaire> getBeneficiaires() {
        return beneficiaires;
    }

    public void setBeneficiaires(List<Beneficiaire> beneficiaires) {
        this.beneficiaires = beneficiaires;
    }
    
    @ManyToMany(cascade={
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name="projet_has_fournisseurs",joinColumns=@JoinColumn(name="projet_id"),
            inverseJoinColumns=@JoinColumn(name="fournisseur_id"))
    private List<Fournisseur> fournisseurs= new ArrayList<Fournisseur>();

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getObjectif() {
        return this.objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public IndicateurPerformance getIndicateurPerformance() {
        return indicateurPerformance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
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
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.Projet[ id=" + id + " ]";
    }
    
}
