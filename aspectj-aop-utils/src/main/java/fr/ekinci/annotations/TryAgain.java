/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ekinci.annotations;

/**
 *
 * @author zouhairhajji
 */
public @interface TryAgain {

    
    public Class<? extends Exception>[] classes();

}
