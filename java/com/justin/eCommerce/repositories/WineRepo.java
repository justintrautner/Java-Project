package com.justin.eCommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.eCommerce.models.Wine;

@Repository
public interface WineRepo extends CrudRepository <Wine, Long> {
	
	List<Wine>findAll();

}
