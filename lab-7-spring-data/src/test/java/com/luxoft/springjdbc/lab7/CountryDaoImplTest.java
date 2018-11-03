package com.luxoft.springjdbc.lab7;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.JavaConfig;
import com.luxoft.service.CountryService;
import com.luxoft.springioc.lab.model.Country;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
@Slf4j
public class CountryDaoImplTest {

	@Autowired
	CountryService countryService;

	@Before
	public void initDB() {
		countryService.countrySave(Country.builder().name("Russia").codeName("RU").build());
		countryService.countrySave(Country.builder().name("America").codeName("US").build());
		countryService.countrySave(Country.builder().name("Japan").codeName("JP").build());
	}

	@After
	public void cleanDB() {
		countryService.deleteAll();
	}

	/*
	 * Получение списка всех стран
	 */
	@Test
	public void getAllCountriesTest() {
		log.info("\n\nПолучение списка всех стран");
		// выбрать из таблицы
		List<Country> countries = new ArrayList<>();
		countries = (List<Country>) countryService.getAllCountries();
		countries.forEach(c -> log.info("{} {}", c.getName(), c.getCodeName()));

		assertThat(countries.size() == 3);
		assertThat(countries.get(0).getCodeName() == "RU");
	}

	/*
	 * Сохранение страны
	 */
	@Test
	public void SaveCountryTest() {
		log.info("\n\nСохранение страны China");
		// изменить название первой страны в списке на China
		countryService.countrySave(Country.builder().name("China").codeName("CH").build());

		// Заново распечатать список стран
		List<Country> countries = new ArrayList<>();
		countries = (List<Country>) countryService.getAllCountries();
		countries.forEach(c -> log.info("{} {}", c.getName(), c.getCodeName()));
		assertEquals(countries.get(countries.size() - 1).getName(), "China");
	}

	/*
	 * Поиск стран по названиею начинающихся на А
	 */
	@Test
	public void CountryByNameTest() {
		log.info("\n\nСписок стран начинающихся на А");
		// Список стран стран начинающихся на А
		Country country = countryService.getCountryByName("A%");
		log.info("{} {}", country.getName(), country.getCodeName());
		assertThat(country.getName().equals("America"));
	}

}
