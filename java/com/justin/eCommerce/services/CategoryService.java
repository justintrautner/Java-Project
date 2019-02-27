package com.justin.eCommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.justin.eCommerce.models.Category;
import com.justin.eCommerce.models.Wine;
import com.justin.eCommerce.repositories.CatRepo;
import com.justin.eCommerce.repositories.WineRepo;

@Service
public class CategoryService {

	private final CatRepo catRepo;
	private final WineRepo wineRepo;

	public CategoryService(CatRepo catRepo, WineRepo wineRepo) {
		this.catRepo = catRepo;
		this.wineRepo = wineRepo;
	}

	public List<Category> findAll() {
		return this.catRepo.findAll();
	}

	public Category findCategoryById(Long id) {
		Optional<Category> cat = catRepo.findById(id);

		if (cat.isPresent()) {
			return cat.get();
		} else {
			return null;
		}
	}

	public Category createCategory(@Valid Category newcategory) {
		return catRepo.save(newcategory);

	}

	public void deleteCategory(Long id) {
		catRepo.deleteById(id);

	}

	public List<Category> findCategoriesNotInWine(Long id) {
		Optional<Wine> optionalWine = wineRepo.findById(id);
		if (optionalWine.isPresent()) {
			Wine wine = optionalWine.get();
			ArrayList<Long> catsId = new ArrayList<Long>();
			if (wine.getCategories().isEmpty() == true) {
				return catRepo.findAll();
			} else {
				for (Category cat : wine.getCategories()) {
					catsId.add(cat.getId());
				}
				return catRepo.findByIdNotIn(catsId);
			}
		} else {
			return null;
		}
	}

}
