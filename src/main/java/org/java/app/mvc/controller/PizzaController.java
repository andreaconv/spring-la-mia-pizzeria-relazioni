package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping()
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String index(Model model) {
//		final String name = "Andrea";
//		model.addAttribute("name", name);
		return "index";
	}
	
	//LISTA DI TUTTE LE PIZZE
//	@GetMapping("/pizze")
//	public String getPizze(Model model) {
//		
//		List<Pizza> pizze = pizzaService.findAll();
//		model.addAttribute("pizze", pizze);
//		return "pizze-index";
//	}

	//LISTA DI TUTTE LE PIZZE SE NON VIENE INSERITO NULLA NEL CAMPO DI RICERCA
	@GetMapping("/pizze")
	public String getPizze(
			Model model, 
			@RequestParam(required = false) String nomePizza) {
		
//		List<Pizza> pizze = null;
//		if(nomePizza == null) {
//			pizze = pizzaService.findAll();
//			model.addAttribute("pizze", pizze);
//		}else {
//			pizze = pizzaService.findByNome(nomePizza);
//			model.addAttribute("pizze", pizze);
//			model.addAttribute("nomePizza", nomePizza);
//		}
		//stessa condizione ma fatta con un ternario
		List<Pizza> pizze = nomePizza == null
						? pizzaService.findAll()
						: pizzaService.findByNome(nomePizza);
		model.addAttribute("pizze", pizze);
		//gli passo anche il nome inserito dall'input per visualizzarlo nella barra di ricerca
		model.addAttribute("nomePizza", nomePizza);
		
		return "pizze-index";
	}
	
	//SHOW DETTAGLIO PIIZA
	@GetMapping("/pizze/{id}")
	public String getShow(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		return "pizza-show";
		
	}
	
	//CREATE NEW PIZZA
	@GetMapping("/pizze/create")
	public String getCreateForm(Model model) {
		
		model.addAttribute("pizza", new Pizza());
		return "pizza-create-edit";
	}
	@PostMapping("/pizze/create")
	public String storePizza(
			@Valid @ModelAttribute Pizza pizza,
			BindingResult bindingResult,
			Model model) {
		
		return savePizza(pizza, bindingResult, model);
	}
	
	//EDIT PIZZA
	@GetMapping("/pizze/update/{id}")
	public String getEditForm(
			@PathVariable int id,
			Model model
		) {

		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);

		return "pizza-create-edit";
	}
	@PostMapping("pizze/update/{id}")
	public String updatePizza(
			@Valid @ModelAttribute Pizza pizza,
			BindingResult bindingResult,
			Model model) {
		
		return savePizza(pizza, bindingResult, model);
	}
	
	//METODO CHE ACCOMUNA IL CREATE E L'EDIT
	private String savePizza(
			Pizza pizza,
			BindingResult bindingResult,
			Model model) {
		
//		System.out.println("New PIzza: " + pizza);
		
		//controlla se non ci sono errori, se dovessero esserci stampa il messaggio attribuito all'errore
		if (bindingResult.hasErrors()) {
			System.out.println("Error:");
			bindingResult.getAllErrors().forEach(System.out::println);
			
			return "pizza-create-edit";
		}else 
			System.out.println("No error");
		
		try {
			pizzaService.save(pizza);
		} catch (Exception e) {
			
			// CONSTRAIN VALIDATION (unique)
			System.out.println("Errore constrain: " + e.getClass().getSimpleName());
			
			model.addAttribute("foto_unique", "Il nome della foto deve essere unica");
			
			return "pizza-create-edit";
		}
		
		return "redirect:/pizze";
	}
	
	//DELETE PIZZA
	@PostMapping("/pizze/delete/{id}")
	public String deletePizza(@PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		pizzaService.deletePizza(pizza);
		
		return "redirect:/pizze";
	}
	
}
