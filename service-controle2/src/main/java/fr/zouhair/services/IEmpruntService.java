/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.zouhair.services;

import fr.zouhair.dtos.HistoryDTO;
import java.util.Optional;

/**
 *
 * @author zouhairhajji
 */
public interface IEmpruntService {

    public Optional<HistoryDTO> empruntExamplaire(String userID, String livreID, String examplaireID);
    
    
}
