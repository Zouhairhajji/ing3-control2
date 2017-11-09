/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.zouhair.controllers;

import fr.zouhair.services.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zouhairhajji
 */
@RestController
public class DefaultController {
    
    
    @Autowired
    private DefaultService defaultService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getHelloMessage() throws Throwable{
        return defaultService.getHelloMessage();
    }
    
}
