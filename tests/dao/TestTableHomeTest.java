package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pojo.TestTable;
import util.HibernateUtil;

public class TestTableHomeTest {

	TestTableHome testTableHome;
	
	@Before
	public void setUp() throws Exception {
		 testTableHome = new TestTableHome();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPersist() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testMerge() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testTryStuff(){
		testTableHome.tryStuff();
	}
	
}
