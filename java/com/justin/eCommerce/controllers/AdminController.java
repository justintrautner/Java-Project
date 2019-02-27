package com.justin.eCommerce.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.justin.eCommerce.models.Category;
import com.justin.eCommerce.models.Wine;
import com.justin.eCommerce.services.CategoryService;
import com.justin.eCommerce.services.WineService;

@Controller
public class AdminController {

	private final WineService wineService;
	private final CategoryService catService;

	public AdminController(WineService wineService, CategoryService catService) {
		this.wineService = wineService;
		this.catService = catService;
	}

//	DASHBOARD
	@GetMapping("/admin")
	public String dashboard(Model model) {
		List<Wine> wines = wineService.findAll();
		List<Category> cats = catService.findAll();
		model.addAttribute("cats", cats);
		model.addAttribute("wines", wines);
		return "admin.jsp";
	}

//	CREATE WINE PAGE
	@GetMapping("/admincreatewine")
	public String createWine(Model model) {
		List<Category> cats = catService.findAll();
		model.addAttribute("cats", cats);
		return "createWine.jsp";
	}
//	CREATE CATEGORY PAGE
	@GetMapping("/admincreatecategory")
	public String createCategory(@Valid @ModelAttribute("newcategory") Category newcategory) {
		
		return "createCategory.jsp";
	}
//	CREATE CATEGORY REQUEST
	@PostMapping("/create/category")
	public String postCategory(@Valid @ModelAttribute("newcategory") Category newcategory, BindingResult result) {
		
		if(result.hasErrors()) {
			return "createCategory.jsp";
		}else {
			catService.createCategory(newcategory);
			return "redirect:/admin";
		}		
	}

//	CREATE WINE REQUEST
	@PostMapping("/create/wine")
	public String postWine(@RequestParam("name") String name, 
			@RequestParam("description") String description,
			@RequestParam("image") String image, 
			@RequestParam("price") Float price,
			@RequestParam("catId") Long catId) {
		Wine newWine = new Wine();
		newWine.setName(name);
		newWine.setDescription(description);
		newWine.setImage(image);
		newWine.setPrice(price);
		Category category = catService.findCategoryById(catId);
		List<Category> catList = new ArrayList<Category>();
		catList.add(category);
		newWine.setCategories(catList);
		wineService.createWine(newWine);
		return "redirect:/admin";
	
	}
//	DELETE CATEGORY
	@GetMapping("/delete/cat/{id}")
	public String deleteCategory(@PathVariable("id") Long id) {
		catService.deleteCategory(id);
		return "redirect:/admin";
	}
//	DELETE WINE
	@GetMapping("/delete/wine/{id}")
	public String deleteWine(@PathVariable("id") Long id) {
		wineService.deleteWine(id);
		return "redirect:/admin";
	}
	
	
	
	
}
