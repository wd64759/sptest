package com.jarta.cloud.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jarta.cloud.data.entities.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{
	
}
