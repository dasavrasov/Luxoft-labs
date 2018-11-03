package com.luxoft.data;

import org.springframework.data.repository.CrudRepository;

import com.luxoft.springioc.lab.model.Country;

public interface CountryDao extends CrudRepository<Country, Long>{
	Country findByName(String name);
	Country findByNameLike(String name);
}