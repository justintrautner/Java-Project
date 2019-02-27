package com.justin.eCommerce.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.justin.eCommerce.models.Category;
import com.justin.eCommerce.repositories.CatRepo;

@Service
public class CategoryService {
	
private final CatRepo catRepo;
	
	public CategoryService(CatRepo catRepo) {
		this.catRepo=catRepo;
	}
	
	public List<Category>findAll(){
		return this.catRepo.findAll();
	}

	
	public Category findCategoryById(Long id) {
		Optional<Category> cat = catRepo.findById(id);
		
		if(cat.isPresent()) {
			return cat.get();
		}else {
			return null;
		}
	}

	public Category createCategory(@Valid Category newcategory) {
		return catRepo.save(newcategory);
		
	}

	public void deleteCategory(Long id) {
		catRepo.deleteById(id);
		
	}

}
