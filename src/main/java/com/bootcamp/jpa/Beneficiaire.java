/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 *
 * @author Ibrahim
 */
@Entity
@Table(name="tp_beneficiaire")
@DiscriminatorValue("BENEFICIAIRE")
public class Beneficiaire extends Personne {

       
@ManyToMany(mappedBy="beneficiaire")
private List<Programme> programmes = new ArrayList<Programme>();
 public List<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }
    
    @ManyToMany(cascade={
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name="beneficiaire_has_projet",joinColumns=@JoinColumn(name="beneficiaire_id"),
            inverseJoinColumns=@JoinColumn(name="projet_id"))
    private List<Projet> projets = new ArrayList<Projet>();

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    

}
