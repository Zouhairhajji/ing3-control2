/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.zouhair.services;

import fr.zouhair.annotations.TryAgain;
import java.io.IOException;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

/**
 *
 * @author zouhairhajji
 */
@Service
public class DefaultService {
    
    
    @TryAgain(classes = {SQLException.class, IOException.class})
    public String  getHelloMessage() throws Throwable{
        throw new Throwable("MyCouCou");
    }
    
}
