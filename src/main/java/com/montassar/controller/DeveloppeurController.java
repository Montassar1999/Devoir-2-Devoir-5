package com.montassar.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.montassar.entities.Developpeur;
import com.montassar.services.DeveloppeurService;

@Controller
public class DeveloppeurController {
@Autowired
DeveloppeurService developpeurService;

@RequestMapping("/showAjout")
public String showAjout(ModelMap modelMap)
{	modelMap.addAttribute("developpeur", new Developpeur());
	modelMap.addAttribute("mode", "new");
	return "formDeveloppeur";
}

@RequestMapping("/saveDeveloppeur")
public String saveDeveloppeur(@Valid Developpeur developpeur,BindingResult bindingResult)
{
if (bindingResult.hasErrors()) return "formDeveloppeur";
developpeurService.saveDeveloppeur(developpeur);
return "formDeveloppeur";
}

/*@RequestMapping("/saveDeveloppeur")
public String saveDeveloppeur(@ModelAttribute("developpeur") Developpeur developpeur, 
 @RequestParam("date") String date,
 ModelMap modelMap) throws
ParseException 
{
//conversion de la date 
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateembauche = dateformat.parse(String.valueOf(date));
 developpeur.setDateEmbauche(dateembauche);
 
Developpeur saveDeveloppeur = developpeurService.saveDeveloppeur(developpeur);
String msg ="Developpeur ajouté avec Id "+saveDeveloppeur.getIdDeveloppeur();
modelMap.addAttribute("msg", msg);
return "createDeveloppeur";
}*/

@RequestMapping("/listeDeveloppeurs")
public String listeDeveloppeurs(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "4") int size)
{
Page<Developpeur> devs = developpeurService.getAllDeveloppeursParPage(page, size);
modelMap.addAttribute("developpeurs", devs);
 modelMap.addAttribute("pages", new int[devs.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeDeveloppeurs";
}


@RequestMapping("/supprimerDeveloppeur")
public String supprimerDeveloppeur(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{

developpeurService.deleteDeveloppeurById(id);
Page<Developpeur> devs = developpeurService.getAllDeveloppeursParPage(page,size);
modelMap.addAttribute("developpeurs", devs);
modelMap.addAttribute("pages", new int[devs.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeDeveloppeurs";
}


@RequestMapping("/modifierDeveloppeur")
public String editerDeveloppeur(@RequestParam("id") Long id,ModelMap modelMap)
{
Developpeur d= developpeurService.getDeveloppeur(id);
modelMap.addAttribute("developpeur", d);
modelMap.addAttribute("mode", "edit");
return "formDeveloppeur";
}

@RequestMapping("/updateDeveloppeur")
public String updateDeveloppeur(@ModelAttribute("developpeur") Developpeur developpeur,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateEmbauche = dateformat.parse(String.valueOf(date));
	 developpeur.setDateEmbauche(dateEmbauche);
	 
	 developpeurService.updateDeveloppeur(developpeur);
	 List<Developpeur> devs = developpeurService.getAllDeveloppeurs();
	 modelMap.addAttribute("developpeurs", devs);
	return "listeDeveloppeurs";

}
}
