package com.luxoft.data;

import java.util.List;

import com.luxoft.springioc.lab6.model.Country;

public interface CountryDao {
	
	List<Country> getCountryList();
	
	void countryChange(Country country, String newName);
	
	public List<Country> getCountryListStartWith(String start);
		
}
