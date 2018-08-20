package com.jarta.cloud.data.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="company")
@Table(name="companies")
@Data
public class Company {
	long id;
	String name;
	String description;
}
