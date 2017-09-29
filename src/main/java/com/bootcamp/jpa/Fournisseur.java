/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Ibrahim
 */
@Entity
public class Fournisseur extends Personne {
    
    @ManyToMany(mappedBy="fournisseurs")
    private List<Programme> programmes = new ArrayList<Programme>();

    public List<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }
    
    @ManyToMany(mappedBy="fournisseurs")
    private List<Projet> projets = new ArrayList<Projet>();

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    
    
}
