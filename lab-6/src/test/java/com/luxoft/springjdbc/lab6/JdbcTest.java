package com.luxoft.springjdbc.lab6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.service.CountryService;
import com.luxoft.springioc.lab6.model.Country;

import lombok.extern.slf4j.Slf4j;


//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@ExtendWith(SpringExtension.class) 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@Slf4j
public class JdbcTest {

	@Autowired
	CountryService countryService; 
	
	@Test
	public void getCountriesTest() {
		//выбрать из таблицы
		List<Country> countries = new ArrayList<>();
		countries=countryService.getCountryList();
		countries.forEach(c->log.info("{} {}",c.getName(),c.getCodeName()));
		
		assertThat(countries.size()==3);
		assertThat(countries.get(0).getCodeName()=="RU");

		log.info("Изменить название первой страны в списке на China");		
		//изменить название первой страны в списке на China
		countryService.countryChange(countries.get(0), "China");
		
		//Заново распечатать список стран
		countries=countryService.getCountryList();
		countries.forEach(c->log.info("{} {}",c.getName(),c.getCodeName()));
		assertEquals(countries.get(0).getName(),"China");
		
		log.info("Список стран стран начинающихся на А");
		//Список стран стран начинающихся на А
		countries=countryService.getCountryListStartWith("A");
		countries.forEach(c->log.info("{} {}",c.getName(),c.getCodeName()));
		assertThat(countries.size()==1);
		
	}
	
}
