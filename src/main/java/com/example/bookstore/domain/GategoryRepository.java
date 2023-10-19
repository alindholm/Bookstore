package com.example.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GategoryRepository extends CrudRepository<Gategory, Long>{

	List<Gategory> findByName(String name);
}
