package com.luxoft.data;

import static lombok.AccessLevel.PRIVATE;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.luxoft.springioc.lab6.model.Country;
import com.luxoft.springioc.lab6.model.CountryImpl;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CountryDaoImpl implements CountryDao{

	DataSource dataSource; 
	
	@Override
	public List<Country> getCountryList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql="SELECT * FROM COUNTRY";
		return jdbcTemplate.query(sql, new CountryRowMapper());
	}

	@Override
	@SneakyThrows
	public List<Country> getCountryListStartWith(String start) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		String sql="SELECT * FROM COUNTRY where name like :start||'%'";
		Map<String, String> params = Collections.singletonMap("start", start);
		
		return jdbcTemplate.query(sql, params, new CountryRowMapper());
	}

	@Override
	public void countryChange(Country country, String newName) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql="UPDATE COUNTRY SET name=? WHERE id=?";
		jdbcTemplate.update(sql, newName, country.getId());
	}

}

class CountryRowMapper implements RowMapper<Country> {
	
	@SneakyThrows
    @Override
    public Country mapRow(ResultSet rs, int rowNum) {
    	Country country = new CountryImpl();
 
    	country.setId(rs.getInt("ID"));
    	country.setName(rs.getString("NAME"));
    	country.setCodeName(rs.getString("CODE_NAME"));
 
        return country;
    }
}