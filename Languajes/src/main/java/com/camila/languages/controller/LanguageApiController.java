package com.camila.languages.controller;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camila.languages.model.LanguageModel;

import com.camila.languages.service.LanguageService;



@RestController
public class LanguageApiController {

	
	@Autowired
	private LanguageService languageService;
	
	
	//1
	@GetMapping("/api/languages")
	public List<LanguageModel> index(){
		return languageService.allLanguages();
	}

	
	//2
	@PostMapping(value="/api/languages")
	public LanguageModel create(
			@RequestParam(value="name")String name,
			@RequestParam(value="creator")String creator,
			@RequestParam(value="version")String version) {
		LanguageModel language = new LanguageModel( name, creator, version);
		return languageService.createLanguages(language);
	}
	
	//3
	@GetMapping("/api/languages/{id}")
	public LanguageModel show(@PathVariable("id") Long id) {
		LanguageModel language = languageService.findLanguage(id);
		return language;
	}
			
	
	   //ACTUALIZAR INFORMACION DE UN LENGUAJE ESPECIFICO
    @PutMapping("/api/languages/{id}")
    public LanguageModel actualizar(@PathVariable("id")Long id,
    		@RequestParam(value="name") String name,
    		@RequestParam(value="creator")String creator,
    		@RequestParam(value= "version")String version) {
    	LanguageModel language = new LanguageModel(id, name, creator, version);
        return languageService.updateLanguage(language);
    	
    }
	
	  @DeleteMapping("/api/languages/{id}")
	  public void borrarRegistro(@PathVariable("id")Long id) {
		  languageService.borrarLanguage(id);
	  }
}
