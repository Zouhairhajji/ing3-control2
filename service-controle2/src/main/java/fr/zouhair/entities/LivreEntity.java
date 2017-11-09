/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.zouhair.entities;

import java.util.List;
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
public class LivreEntity {

    private Long idLivre;
    private CategorieEnum categorie;
    private Boolean isNew;
    private List<ExamplaireEntity> examplaires;

    public enum CategorieEnum {
        science_fiction,
        biographie,
        action;
    }
}
