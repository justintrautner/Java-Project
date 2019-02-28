package com.justin.eCommerce.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
		List<Wine> wines = wineService.findAll();
		List<Category> cats = catService.findAll();
		model.addAttribute("cats", cats);
		model.addAttribute("wines", wines);
		return "admin.jsp";
	}

//	CREATE WINE PAGE
	@GetMapping("/admincreatewine")
	public String createWine(Model model, HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
		List<Category> cats = catService.findAll();
		model.addAttribute("cats", cats);
		return "createWine.jsp";
	}
//	CREATE CATEGORY PAGE
	@GetMapping("/admincreatecategory")
	public String createCategory(Model model, @Valid @ModelAttribute("newcategory") Category newcategory, HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
		List<Category> cats=catService.findAll();
		model.addAttribute("cats", cats);
		return "createCategory.jsp";
	}
//	CREATE CATEGORY REQUEST
	@PostMapping("/create/category")
	public String postCategory(@Valid @ModelAttribute("newcategory") Category newcategory, BindingResult result, HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
		if(result.hasErrors()) {
			return "createCategory.jsp";
		}else {
			catService.createCategory(newcategory);
			return "redirect:/admin";
		}		
	}

//	CREATE WINE REQUEST
	@PostMapping("/create/wine")
	public String postWine(HttpSession session,
			@RequestParam("name") String name, 
			@RequestParam("description") String description,
			@RequestParam("image") String image, 
			@RequestParam("price") Float price,
			@RequestParam("catId") Long catId) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
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
	public String deleteCategory(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
		catService.deleteCategory(id);
		return "redirect:/admin";
	}
//	DELETE WINE
	@GetMapping("/delete/wine/{id}")
	public String deleteWine(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
		wineService.deleteWine(id);
		return "redirect:/admin";
	}
//	EDIT WINE
	@GetMapping("/editwine{id}")
	public String editWine(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("updatedWine") Wine updatedWine, HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
		Wine wine = wineService.findWineById(id);
		model.addAttribute("wine", wine);
		List<Category> cats = catService.findAll();
		model.addAttribute("cats", cats);
		// Other Categories
		List<Category> others = catService.findCategoriesNotInWine(id);
		model.addAttribute("others", others);
		return "editWine.jsp";
	}
//	EDIT REQUEST
	@PutMapping("/edit/wine/{id}")
	public String putWine(@PathVariable("id") Long id, @Valid @ModelAttribute("updatedWine") Wine updatedWine, BindingResult result, HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
		if(result.hasErrors()) {
			return "redirect:/editwine"+id;
		}else {
			Wine wine = wineService.findWineById(id);
			updatedWine.setCategories(wine.getCategories());
			wineService.updateWine(updatedWine);
			return "redirect:/admin";
		}
		
	}
//	ADD CATEGORY
	@PostMapping("/edit/wine/{id}")
	public String addCategory(@PathVariable("id") Long id, @RequestParam("categoryId") Long categoryId, HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
		Category category = catService.findCategoryById(categoryId);
		Wine wine = wineService.findWineById(id);
		List <Category> catList = wine.getCategories();
		catList.add(category);
		wine.setCategories(catList);
		wineService.updateWine(wine);
		return "redirect:/admin";
	}
//	REMOVE CATEGORY
	@PostMapping("/edit/wine/{id}/remove")
	public String removeCategory(@PathVariable("id") Long id, @RequestParam("idx") int idx, HttpSession session) {
		if(session.getAttribute("admin")==null) {
			return "redirect:/login";
		}
		Wine wine = wineService.findWineById(id);
		List<Category> catList = wine.getCategories();
		catList.remove(idx);
		wine.setCategories(catList);
		wineService.updateWine(wine);
		return "redirect:/admin";
	}
//	LOGIN
	@GetMapping("/login")
	public String login() {
		
		return "login.jsp";
	}
//	LOGIN REQUEST
	@PostMapping("/login")
	public String loginAdmin(HttpSession session, @RequestParam Map<String,String> params) {
		if(params.get("name").equals("admin") && params.get("password").equals("999999999")) {
			session.setAttribute("admin", true);
			return "redirect:/admin";
		}else {
			return "redirect:/login";
		}	
	}
//	LOGOUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:/login";
	}
	
	
	
	
}
