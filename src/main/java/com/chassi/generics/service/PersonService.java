package com.chassi.generics.service;

import com.chassi.generics.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends GenericService<Person,Long>{

}
