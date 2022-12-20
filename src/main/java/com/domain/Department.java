package com.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DEPT_A")
public class Department {

	@Id	// primary key 
	// @GeneratedValue(strategy=GenerationType.SEQUENCE) 시퀀스 처리
	private int 	deptno;
	private String  dname;
	private String  loc;
	
	@OneToMany(mappedBy="dept", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})		// 해당 부서의 사원 리스트 장착하기
	private List<Employee> employeeList = new ArrayList<Employee>();
	
}
