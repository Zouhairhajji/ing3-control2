/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.zouhair.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *
 * @author zouhairhajji
 */
@Target(ElementType.METHOD)
public @interface TryAgain {
    
    public Class<? extends Throwable>[] classes();
    
}
