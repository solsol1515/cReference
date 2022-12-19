package com.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DEPT_A")
public class Department {

	@Id	// primary key 
	// @GeneratedValue(strategy=GenerationType.SEQUENCE) 시퀀스 처리
	private int deptno;
	private String dname;
	private String loc;
	
}
