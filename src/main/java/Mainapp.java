

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.Department;
import com.domain.Employee;

public class Mainapp {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cReference"); 

		try {
			
			// [1]_1 연관관계를 이용한 데이터 검색
			// selectData(emf);
			
			// [2]_1 연관관계를 이용한 데이터 입력
			// insertData(emf);
			
			// [3] 연관관계를 이용한 데이터 수정
			// updateData(emf);
			
			// [4] 연간관계를 이용한 데이터 삭제 
			deleteData(emf);
			
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

	// [3] 연관관계를 이용한 데이터 수정
	static void updateData(EntityManagerFactory emf) {
		
		// 사번이 7369인 사원의 부서를 40번 부서로 변경
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// 사원의 정보를 찾아 Employee Class에 저장하고 사번의 정보를 찾아 Department class 에 저장
		// 이후 해당하는 클래스들을 Entity Manager를 이용해 On-Loading
		Employee e1 = em.find(Employee.class, 7369);		// 사번 7369인 사람 찾기
		Department dept = em.find(Department.class, 40);	// 부서 번호 40인 사람 찾기
		
		em.persist(dept);
		e1.setDept(dept);
		em.persist(e1);
		
		tx.commit();
		em.close();
		
	} // end of updateData()
	
	// [4] 연간관계를 이용한 데이터 삭제
	static void deleteData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// 40번 부서를 삭제
		Department dpt = em.find(Department.class, 40);
		// System.out.println(dpt);
		em.remove(dpt);
		
		// 포링키로 묶여있는 경우 에러 발생 !!
		// [해결 1] 사원 테이블에서 40번 부서의 내용을 null로 수정
		// [해결 2] 40번 부서의 사원 정보를 먼저 삭제
		
		tx.commit();
		em.close();
	
	}
	
} // end of class
