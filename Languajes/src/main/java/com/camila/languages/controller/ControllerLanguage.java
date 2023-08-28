package com.camila.languages.controller;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import com.camila.languages.service.LanguageService;
import com.camila.languages.model.LanguageModel;

@SuppressWarnings("unused")
@Controller
public class ControllerLanguage {
@Autowired
private final LanguageService languageService = new LanguageService();


@GetMapping("/")
public String raiz() {
	return "redirect:/languages";
}


//TODAS LAS LENGUAS 1
@GetMapping("/languages")
public String index(Model model) {
    List<LanguageModel> languages = languageService.allLanguages();
    model.addAttribute("languages", languages);
    return "languages/index.jsp";
}
	
//CREAR UNA NUEVA LENGUA2

@PostMapping("/languages")
public String create(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result, Model model) {
    if (result.hasErrors()) {
        List<LanguageModel> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "languages/index.jsp";
    } else {
        languageService.createLanguages(language);
        return "redirect:/languages";
    }
}


	//INFORMACION DE UNA LENGUA 3
@GetMapping("/languages/{id}")
public String show(@PathVariable Long id, Model model) {
    LanguageModel language = languageService.findLanguage(id);

    if (language != null) {
        model.addAttribute("language", language);
        return "languages/show.jsp";
    } else {
        return "redirect:/languages";
    }
}
	
	//MODIFICAR UNA LENGUA 4
@GetMapping("/languages/{id}/edit")
public String edit(@PathVariable("id") Long id, Model model) {
	LanguageModel language = languageService.findLanguage(id);
	model.addAttribute("language", language);
	return "languages/edit.jsp";
}
	
@PutMapping(value="/languages/{id}")
public String update(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result) {
	if (result.hasErrors()) {
		return "/languages/edit.jsp";
	} else {
		languageService.updateLanguage(language);
		return "redirect:/languages";
	}
}
	
	
	//ELIMINAR UNa LENGUA	 5

	@DeleteMapping(value="/languages/{id}")
public String destroy(@PathVariable("id") Long id) {
    languageService.borrarLanguage(id);
    return "redirect:/languages";
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	

}
