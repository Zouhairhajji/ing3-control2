/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.zouhair.dtos;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author zouhairhajji
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDTO {
    
    
    private Timestamp dateEmprunt;
    
    private Timestamp dateRetour;
    
    private String idUtilisateur;
    
    private String firstname;
    
    private String lastname;
    
    private String idExamplaire;
    
}
