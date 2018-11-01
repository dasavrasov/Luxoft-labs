package com.luxoft.service;

import static lombok.AccessLevel.PRIVATE;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luxoft.data.CountryDao;
import com.luxoft.springioc.lab.model.Country;

import lombok.experimental.FieldDefaults;

//@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Service(value="countryService")
@Transactional
public class CountryService {

	@Resource(name="countryDao")
	CountryDao countryDao;
		
	public Iterable<Country> getAllCountries(){
		return countryDao.getCountryList();
	}

//	public void countrySave(Country country) {
//		countryDao.save(country);
//	}
	
	public Country getCountryByName(String name) {
		return countryDao.findByName(name);
	}
	
	public void countrySave(Country country) {
		countryDao.save(country);
	}
}
