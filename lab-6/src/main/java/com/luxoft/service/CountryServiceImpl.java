package com.luxoft.service;

import static lombok.AccessLevel.PRIVATE;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luxoft.data.CountryDao;
import com.luxoft.springioc.lab6.model.Country;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
//@Service("countryService")
public class CountryServiceImpl implements CountryService {

	CountryDao countryDao;
	
	public List<Country> getCountryList(){
		return countryDao.getCountryList();
	}

	@Override
	public void countryChange(Country country, String newName) {
		countryDao.countryChange(country, newName);
	}
	
	public List<Country> getCountryListStartWith(String start) {
		return countryDao.getCountryListStartWith(start);
	}
}
