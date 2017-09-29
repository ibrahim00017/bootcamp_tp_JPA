/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Ibrahim
 */
@Entity
public class Bailleur extends Personne {
   
    
    @Column(length=45)
    private TypeDeBailleur typeDeBailleur;
    
   
    
@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
@JoinTable(name="bailleur_has_projet",joinColumns=@JoinColumn(name="bailleur_id"),inverseJoinColumns=@JoinColumn(name="projet_id"))

 private List<Projet> projets = new ArrayList<Projet>();

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }


@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
@JoinTable(name="bailleur_has_programme",joinColumns=@JoinColumn(name="bailleur_id"),inverseJoinColumns=@JoinColumn(name="programme_id"))
private List<Programme> programmes = new ArrayList<Programme>();

    public List<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }



}
