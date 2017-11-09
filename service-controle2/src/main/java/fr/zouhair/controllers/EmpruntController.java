/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.zouhair.controllers;

import fr.zouhair.dtos.HistoryDTO;
import fr.zouhair.services.IEmpruntService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zouhairhajji
 */
@RestController
@RequestMapping(value = "emprunt")
public class EmpruntController {
    
    @Autowired
    private IEmpruntService empruntService;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> empruntExamplaire(@RequestParam(value = "idUtilisateur", required = true) String userID,
            @RequestParam(value = "idLivre", required = true) String livreID,
            @RequestParam(value = "idExamplaire", required = true) String examplaireID){
        try {
            Optional<HistoryDTO> optDTO =  this.empruntService.empruntExamplaire(userID, livreID, examplaireID);
            if(optDTO.isPresent()){
                return new ResponseEntity(optDTO.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
            }
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
