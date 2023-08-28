package com.camila.languages.repositorio;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camila.languages.model.LanguageModel;



@Repository
public interface LanguageRepo extends CrudRepository<LanguageModel, Long> {


    //ESTE MÉTODO RECUPERA TODOS LOS LENGUAJES DE LA BASE DE DATOS
    List<LanguageModel> findAll();
    
    //ESTE MÉTODO ENCUENTRA UN LENGUAJE POR SU DESCRIPCIÓN
    List<LanguageModel> findByDescriptionContaining(String search);
    
    //ESTE MÉTODO CUENTA CUÁNTOS LENGUAJES CONTIENE CIERTA CADENA EN EL TÍTULO
    Long countByTitleContaining(String search);
    
    //ESTE MÉTODO BORRA UN LENGUAJE QUE EMPIEZA CON UN TÍTULO ESPECÍFICO
   Long deleteByTitleStartingWith(String search);

}
