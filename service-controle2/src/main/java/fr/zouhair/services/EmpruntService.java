/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.zouhair.services;

import fr.zouhair.dtos.HistoryDTO;
import fr.zouhair.entities.ExamplaireEntity;
import fr.zouhair.entities.HistoriqueEntity;
import fr.zouhair.entities.LivreEntity;
import fr.zouhair.entities.UtilisateurEntity;
import fr.zouhair.repositories.ExamplaireRepository;
import fr.zouhair.repositories.HistoriqueRepository;
import fr.zouhair.repositories.LivreRepository;
import fr.zouhair.repositories.UtilisateurRepository;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zouhairhajji
 */
@Service
public class EmpruntService implements IEmpruntService{

    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    private ExamplaireRepository examplaireRepository;
    
    @Autowired
    private LivreRepository livreRepository;
    
    @Autowired
    private HistoriqueRepository historiqueRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    @Override
    public Optional<HistoryDTO> empruntExamplaire(String userID, String livreID, String examplaireID) {
        UtilisateurEntity user = this.userRepository.findOne(Long.valueOf(userID));
        if(user ==  null){
            return Optional.empty();
        }
        
        ExamplaireEntity examplaire = this.examplaireRepository.findOne(Long.valueOf(examplaireID));
        if(examplaire ==  null){
            return Optional.empty();
        }
        
        LivreEntity livre = this.livreRepository.findOne(Long.valueOf(livreID));
        if(livre ==  null){
            return Optional.empty();
        }
        
        List<HistoriqueEntity> historiqueByUtilisateur = this.historiqueRepository.findHistoriqueDateRetourNotNullByUtilisateur(user);
        
        int nbrLoc = historiqueByUtilisateur.size();
        if(nbrLoc > 9){
            return Optional.empty();
        }
        if (historiqueByUtilisateur.stream().filter(s -> s.getExamplaire().getLivre().getIsNew()).count() > 3){
            return Optional.empty();
        }
        
        HistoriqueEntity historique = HistoriqueEntity.builder()
                .dateEmprunt(new Timestamp(System.currentTimeMillis()))
                .dateRetour(null)
                .examplaire(examplaire)
                .idHistory(0L)
                .utilisateur(user)
                .build();
        
        this.historiqueRepository.save(historique);
        return Optional.of(this.mapper.map(historique, HistoryDTO.class));
    }
    
}
