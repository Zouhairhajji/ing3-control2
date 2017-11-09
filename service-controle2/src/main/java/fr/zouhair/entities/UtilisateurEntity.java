/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.zouhair.entities;

import java.util.List;
import javax.persistence.OneToMany;
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
public class UtilisateurEntity {
    
    private Long idUtilisateur;
    private String firstname;
    private String lastname;
    
    
    
    @OneToMany(mappedBy = "utilisateur")
    private List<HistoriqueEntity> histories;
    
}
