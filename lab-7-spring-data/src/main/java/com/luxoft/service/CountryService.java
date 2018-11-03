package com.luxoft.service;

import static lombok.AccessLevel.PRIVATE;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luxoft.data.CountryDao;
import com.luxoft.springioc.lab.model.Country;

import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
@Service(value="countryService")
public class CountryService {

	@Resource(name="countryDao")
	CountryDao countryDao;
		
	public Iterable<Country> getAllCountries(){
		return countryDao.findAll();
	}

	public Country getCountryByName(String name) {
		return countryDao.findByNameLike(name);
	}
	
	public void countrySave(Country country) {
		countryDao.save(country);
	}
	
	public void deleteAll() {
		countryDao.deleteAll();	
	}
}
