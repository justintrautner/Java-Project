package com.justin.eCommerce.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.justin.eCommerce.models.Category;
import com.justin.eCommerce.models.Wine;
import com.justin.eCommerce.services.CategoryService;
import com.justin.eCommerce.services.WineService;

@Controller
public class RoutingController {

	private final WineService wineService;
	private final CategoryService catService;

	public RoutingController(WineService wineService, CategoryService catService) {
		this.wineService = wineService;
		this.catService = catService;
	}

//	HOME PAGE
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("cart") == null) {
			ArrayList<HashMap<String, String>> cart = new ArrayList<>();
			HashMap<String, String> total = new HashMap<String, String>();
			total.put("total", "0");
			total.put("totalPrice", "0");
			cart.add(total);
			session.setAttribute("cart", cart);
		}
		List<Wine> featuredWines = wineService.findByIsFeaturedTrue();
		List<Category> cats =catService.findAll();
		model.addAttribute("featuredWines", featuredWines);
		model.addAttribute("cats", cats);
		model.addAttribute("cart", session.getAttribute("cart"));
		return "index.jsp";
	}

//	ALL PRODUCTS PAGE
	@GetMapping("/shop")
	public String wines(Model model, HttpSession session) {
		if (session.getAttribute("cart") == null) {
			ArrayList<HashMap<String, String>> cart = new ArrayList<>();
			HashMap<String, String> total = new HashMap<String, String>();
			total.put("total", "0");
			total.put("totalPrice", "0");
			cart.add(total);
			session.setAttribute("cart", cart);
		} else {
			model.addAttribute("cart", session.getAttribute("cart"));
		}
		List<Category> cats = catService.findAll();
		List<Wine> allWines = wineService.findAll();
		model.addAttribute("cats", cats);
		model.addAttribute("allWines", allWines);
		session.setAttribute("cat-filter", Long.valueOf(0));
		session.setAttribute("price-filter", (float) 0);
		return "wines.jsp";
	}

//	SINGLE PRODUCT PAGE
	@GetMapping("/wine{id}")
	public String wine(@PathVariable("id") Long id, HttpSession session, Model model) {
		if (session.getAttribute("cart") == null) {
			ArrayList<HashMap<String, String>> cart = new ArrayList<>();
			HashMap<String, String> total = new HashMap<String, String>();
			total.put("total", "0");
			total.put("totalPrice", "0");
			cart.add(total);
			session.setAttribute("cart", cart);
		} else {
			model.addAttribute("cart", session.getAttribute("cart"));
		}
		List<Category> cats =catService.findAll();
		model.addAttribute("cats", cats);
		Wine wine = wineService.findWineById(id);
		model.addAttribute("wine", wine);
		return "oneWine.jsp";
	}

//	ABOUT
	@GetMapping("/about")
	public String about(Model model) {
		List<Category> catList =catService.findAll();
		model.addAttribute("cats", catList);

		return "about.jsp";
	}
	
//	CONTACT
	@GetMapping("/contact")
	public String contact(Model model) {
		List<Category> catList =catService.findAll();
		model.addAttribute("cats", catList);

		return "contact.jsp";
	}

}
