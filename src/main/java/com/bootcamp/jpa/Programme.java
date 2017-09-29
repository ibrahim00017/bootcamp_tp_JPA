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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ibrahim
 */
@Entity
@Table(name="tp_programme")
public class Programme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return this.id;
    }
    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="programme_has_beneficiaire",joinColumns=@JoinColumn(name="programme_id"),
      inverseJoinColumns=@JoinColumn(name="beneficiaire_id"))
    private List<Beneficiaire> beneficiaires;

    public List<Beneficiaire> getBeneficiaires() {
        return beneficiaires;
    }

    public void setBeneficiaires(List<Beneficiaire> beneficiaires) {
        this.beneficiaires = beneficiaires;
    }
    
    @ManyToMany(mappedBy="programmes")
    private List<Bailleur> bailleurs= new ArrayList<Bailleur>();

    public List<Bailleur> getBailleurs() {
        return bailleurs;
    }

    public void setBailleurs(List<Bailleur> bailleurs) {
        this.bailleurs = bailleurs;
    }
    // ManyToMany for the relation programme_has_fournisseur
    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="programme_has_fournisseur",
            joinColumns=@JoinColumn(name="programme_id"),
            inverseJoinColumns=@JoinColumn(name="fournisseur_id"))
    private List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }
    
    
    @Column(length=45)
    private String nom;
    
    @Column(length=45)
    private String objectif;
    
    @OneToOne
    private IndicateurPerformance indicateurPerformance;

  
    
    

    public IndicateurPerformance getIndicateurPerformance() {
        return this.indicateurPerformance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
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
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.Programme[ id=" + id + " ]";
    }
    
}
