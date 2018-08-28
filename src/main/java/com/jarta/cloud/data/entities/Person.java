package com.jarta.cloud.data.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity(name="person")
@Table(name="persons")
@Data
public class Person {
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	long pid;
	String name;
	String cnName;
	int female;
	long phone;
	Date birthday;
	Date linkDate;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cid")
	Company company;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ToString.Exclude List<Career> careers;
}
