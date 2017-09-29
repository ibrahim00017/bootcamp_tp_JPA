/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa;

/**
 *
 * @author Ibrahim
 */
    public enum TypeDeBailleur {
    
    ONG("Non gouvernementale"),
    PRIVE("Prive"),
    G("Gouvernementale"),
    PI("Partenaire international");
    
    private final String name;
    
    private TypeDeBailleur(String name){
        this.name=name;
    }
       
}
