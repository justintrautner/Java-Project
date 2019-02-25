package com.justin.eCommerce.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		this.catService=catService;
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
		List<Category> allCats = catService.findAll();
		List<Wine> allWines = wineService.findAll();
		model.addAttribute("allCats", allCats);
		model.addAttribute("allWines", allWines);
		return "wines.jsp";
	}

}
