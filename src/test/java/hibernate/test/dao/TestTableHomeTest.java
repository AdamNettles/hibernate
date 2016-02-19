package hibernate.test.dao;

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

import dao.TestTableHome;
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

//	@Test
//	public void testPersist() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRemove() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testMerge() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindById() {
//		fail("Not yet implemented");
//	}

	// @Test
	// public void testUpdateTextcol(){
	// testTableHome.updateTextcol(1,"Changed!!");
	// testTableHome.updateTextcol(2,"Changed!!");
	// }

//	@Test
//	public void testInsert() {
//		int rowcount = 10;
//		Session session = null;
//		for (int i = 1; i <= rowcount; i++) {
//			TestTable testTable = new TestTable();
//			testTable.setTextCol(String.format("adding number %s", i));
//			try {
//				Hibernate.initialize(testTable);
//				session = HibernateUtil.getSessionFactory().openSession();
//				Transaction transaction = null;
//				try {
//					transaction = session.beginTransaction();
//					session.save(testTable); // POJO PK field generatortype MUST be IDENTITY for postgres SERIAL PKs
//					transaction.commit();
//				} catch (Exception e) {
//					if (transaction != null)
//						transaction.rollback();
//					e.printStackTrace();
//				} finally {
//					session.close();
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				if (session != null && session.isOpen()) {
//					session.close();
//				}
//			}
//		}
//	}

	@Test
	public void testSelectAll() {
		String entityName = "TestTable";
		Session session = null;
			TestTable testTable = new TestTable();
			try {
				Hibernate.initialize(testTable);
				session = HibernateUtil.getSessionFactory().openSession();
				Transaction transaction = null;
				List<TestTable> allTestTableFromHQL = null;
				List<TestTable> allTestTableFromSQL = null;
				try {
					transaction = session.beginTransaction();
					//HQL query with no filters
					allTestTableFromHQL = session.createQuery(String.format("from %s",entityName)).list();
					allTestTableFromSQL = session.createSQLQuery("select * from adam_schema.test_table").list();
					//SQL query with no filters
					
					transaction.commit();
				} catch (Exception e) {
					if (transaction != null)
						transaction.rollback();
					e.printStackTrace();
				} finally {
					session.close();
					if (allTestTableFromHQL!=null) {
						System.out.println(String.format("using hql %s has size %s",entityName, allTestTableFromHQL.size()));
					}
					if (allTestTableFromSQL!=null){
						System.out.println(String.format("using sql adam_schema.test_table has size %s", allTestTableFromSQL.size()));
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		
	}
}
