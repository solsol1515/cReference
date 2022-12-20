package com.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EMP_A")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer empno;
	
	private String  ename;
	private String  job;
	private Integer mgr;
	private Date 	hiredate;
	private Integer sal;
	private Integer comm;
	
	@ManyToOne(optional = false,
			fetch = FetchType.LAZY)		// 사원 한 명의 부서를 하나로 지정 (부서 중복 안되게!_optional=true)
	@JoinColumn(name="deptno")
	private Department dept;


	
}
