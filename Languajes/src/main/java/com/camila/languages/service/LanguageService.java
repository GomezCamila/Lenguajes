package com.camila.languages.service;
import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camila.languages.model.LanguageModel;

import com.camila.languages.repositorio.LanguageRepo;

@SuppressWarnings("unused")
@Service
public class LanguageService {

	@Autowired
	private LanguageRepo languagerepo;
	
	
	 //DEVOLVIENDO TODOS LOS LENGUAJES
    public List<LanguageModel> allLanguages() {
        return languagerepo.findAll();
    }
    
    //CREANDO UN LENGUAJE
    public LanguageModel createLanguages(LanguageModel b) {
        return LanguageService.save(b);
    }
    
    private static LanguageModel save(LanguageModel b) {
		// TODO Auto-generated method stub
		return null;
	}

	//OBTENIENDO LOS DETALLES DE UN LENGUAJE EN ESPECÍFICO
    public LanguageModel findLanguage(Long id) {
        Optional<LanguageModel> optionalLanguage = languagerepo.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
  //ACTUALIZAR INFORMACION
    public LanguageModel updateLanguage(LanguageModel language) {
    	LanguageModel temporal = findLanguage(language.getId());
    	temporal.setName(language.getName());
    	temporal.setCreator(language.getCreator());
    	temporal.setVersion(language.getVersion());
    	
    	return languagerepo.save(temporal);
    }
    //SOBRECARGA DE METODO DE ACTUALIZAR INFORMACION
	public <languagerepo> LanguageModel updateLanguage(Long id,
			String name, 
			String creator, 
			String version) {
		LanguageModel temporal = languagerepo.findById(id).orElse(null);
		if(temporal != null) {
			temporal.setName(name);
			temporal.setCreator(creator);
			temporal.setVersion(version);
			
			languagerepo.save(temporal);
			return temporal;
		}else {
			return temporal;
		}
	}
	
	//BORRAR UN LENGUAJE
	public void borrarLanguage(Long id) {
		languagerepo.deleteById(id);
	}

}
