package com.luxoft.springioc.lab.model;

import static lombok.AccessLevel.PRIVATE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@Component("country")
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
@Entity
public class Country{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  Long id;

  String name;

  @Column(name="code_name")
  String codeName;

  public Country(String name, String codeName) {
    this.name = name;
    this.codeName = codeName;
  }
}
