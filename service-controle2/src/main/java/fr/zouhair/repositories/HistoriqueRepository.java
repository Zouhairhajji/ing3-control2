/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.zouhair.repositories;

import fr.zouhair.entities.HistoriqueEntity;
import fr.zouhair.entities.UtilisateurEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author zouhairhajji
 */
public interface HistoriqueRepository extends CrudRepository<HistoriqueEntity, Long>{
    
    public List<HistoriqueEntity> findHistoriqueDateRetourNotNullByUtilisateur(UtilisateurEntity utilisateurEntity);
    
}
