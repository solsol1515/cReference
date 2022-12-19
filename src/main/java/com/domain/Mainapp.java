package com.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Mainapp {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cReference"); 

		try {
			
			// [1]_1 연관관계를 이용한 데이터 검색
			// selectData(emf);
			
			// [2]_1 연관관계를 이용한 데이터 입력
			insertData(emf);
			
		}catch(Exception ex) {
			System.out.println("예외: "+ex.getMessage());
		}finally {
			emf.close();
		} // end of finally
		
	} // end of main

	// [1]_2 연관관계를 이용한 데이터 검색
	static void selectData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		Employee e1 = em.find(Employee.class, 7788);
		System.out.println(e1);
		
		System.out.println(e1.getEname() + "님 정보");
		System.out.println("부서: " + e1.getDept().getDname());
		
		em.close();
	} // end of selectData()
	
	// [2]_2 연관관계를 이용한 데이터 입력
	static void insertData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Employee emp1 = new Employee();
		emp1.setEname("맹홍3");
		
		// Department dept = em.find(Department.class, 40);
		// 새로운 부서에 새 직원 들어가기
		Department dept = new Department();
		dept.setDeptno(50);
		dept.setDname("아이티");
		dept.setLoc("인천");
		em.persist(dept);
		
		emp1.setDept(dept);
		
		em.persist(emp1);			// 연결 
		
		tx.commit();
		em.close();
	} // end of insertData()

} // end of class
