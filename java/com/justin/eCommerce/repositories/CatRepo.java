package com.justin.eCommerce.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.eCommerce.models.Category;

@Repository
public interface CatRepo extends CrudRepository <Category, Long> {
	
	List<Category>findAll();

	List<Category> findByIdNotIn(ArrayList<Long> catsId);

}
