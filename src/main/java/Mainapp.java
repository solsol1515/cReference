

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.domain.Employee;

public class Mainapp {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cReference"); 

		try {
			
			// [1] 연관관계를 이용한 데이터 검색
			selectData(emf);
			
		}catch(Exception ex) {
			System.out.println("예외: "+ex.getMessage());
		}finally {
			emf.close();
		}
		
	}

	// [1] 연관관계를 이용한 데이터 검색
	static void selectData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		
		Employee e1 = em.find(Employee.class, 7788);
		System.out.println(e1);
		
		System.out.println(e1.getEname() + "님 정보");
		System.out.println("부서: " + e1.getDept().getDname());
		
		em.close();
	}
	
}
