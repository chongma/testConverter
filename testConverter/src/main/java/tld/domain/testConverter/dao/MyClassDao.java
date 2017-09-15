package tld.domain.testConverter.dao;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import tld.domain.testConverter.entities.MyClass;
import tld.domain.testConverter.entities.MyClassTable1;
import tld.domain.testConverter.entities.MyClassTable2;
import tld.domain.testConverter.entities.MyClassTable3;
import tld.domain.testConverter.entities.MyClassTable4;

@ApplicationScoped
public class MyClassDao {

	@Inject
	private EntityManager em;

	public List<MyClassTable1> selectTable1() {
		return em.createQuery("SELECT m FROM MyClassTable1 m", MyClassTable1.class).getResultList();
	}

	public List<MyClassTable2> selectTable2() {
		return em.createQuery("SELECT m FROM MyClassTable2 m", MyClassTable2.class).getResultList();
	}

	public List<MyClassTable3> selectTable3() {
		return em.createQuery("SELECT m FROM MyClassTable3 m", MyClassTable3.class).getResultList();
	}

	public List<MyClassTable4> selectTable4() {
		return em.createQuery("SELECT m FROM MyClassTable4 m", MyClassTable4.class).getResultList();
	}

	@Transactional
	public void create1() {
		MyClassTable1 myClassTable1 = new MyClassTable1();
		myClassTable1.setMyClass(initialise());
		em.persist(myClassTable1);
	}

	@Transactional
	public void create2() {
		MyClassTable2 myClassTable2 = new MyClassTable2();
		myClassTable2.setMyClass(initialise());
		em.persist(myClassTable2);
	}

	@Transactional
	public void create3() {
		MyClassTable3 myClassTable3 = new MyClassTable3();
		myClassTable3.setMyClass(initialise());
		em.persist(myClassTable3);
	}

	@Transactional
	public void create4() {
		MyClassTable4 myClassTable4 = new MyClassTable4();
//		myClassTable4.setMyClass(initialise());
		em.persist(myClassTable4);
	}

	@Transactional
	public void update1(MyClassTable1 myClassTable1) {
		random(myClassTable1.getMyClass());
		em.merge(myClassTable1);
	}

	@Transactional
	public void update2(MyClassTable2 myClassTable2) {
		random(myClassTable2.getMyClass());
		em.merge(myClassTable2);
	}

	@Transactional
	public void update3(MyClassTable3 myClassTable3) {
		random(myClassTable3.getMyClass());
		em.merge(myClassTable3);
	}

	@Transactional
	public void update4(MyClassTable4 myClassTable4) {
//		random(myClassTable4.getMyClass());
		em.merge(myClassTable4);
	}

	private MyClass initialise() {
		MyClass myClass = new MyClass();
		random(myClass);
		return myClass;
	}

	private void random(MyClass myClass) {
		String body = UUID.randomUUID().toString();
		myClass.setBody(body);
	}
}
