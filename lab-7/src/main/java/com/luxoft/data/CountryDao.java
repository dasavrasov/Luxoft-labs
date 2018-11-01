package com.luxoft.data;

import java.util.List;

import com.luxoft.springioc.lab.model.Country;

public interface CountryDao {
	List<Country> getCountryList();
	Country findByName(String name);
	void save(Country country);
}