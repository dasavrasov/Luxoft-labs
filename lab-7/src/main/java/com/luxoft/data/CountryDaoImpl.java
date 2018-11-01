package com.luxoft.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luxoft.springioc.lab.model.Country;

@Repository("countryDao")
@Scope("prototype")
public class CountryDaoImpl implements CountryDao {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	protected EntityManager entityManager;	
	
	@Transactional(readOnly = true)
	public List<Country> getCountryList() {
		return entityManager.createQuery("from Country",Country.class).getResultList(); 
	}
	
	@Transactional(readOnly = true)
	public Country findByName(String name) {
		return (Country)entityManager.createQuery("select c from Country c where name like :name||'%'", Country.class).setParameter("name",name).getSingleResult();
	}
	
	@Transactional
	public void save(Country country) {
		entityManager.persist(country);
	}
}
