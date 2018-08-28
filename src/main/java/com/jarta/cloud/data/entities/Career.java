package com.jarta.cloud.data.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="career")
@Table(name="careers")
@Data
public class Career {
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	long cid;
	long pid;
	Date startDt;
	Date endDt;
	String role;
	String scope;
	int valindex;
}
