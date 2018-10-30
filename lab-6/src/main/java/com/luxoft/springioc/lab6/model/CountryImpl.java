package com.luxoft.springioc.lab6.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@Component("country")
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CountryImpl implements Country {

  int id;

  String name;

  String codeName;

  public CountryImpl(String name, String codeName) {
    this.name = name;
    this.codeName = codeName;
  }
}
