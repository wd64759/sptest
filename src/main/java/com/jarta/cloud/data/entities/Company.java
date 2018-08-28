package com.jarta.cloud.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="company")
@Table(name="companies")
@Data
public class Company {
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	long id;
	String name;
	String description;
}
