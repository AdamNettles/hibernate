package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.TestTable;
import util.HibernateUtil;

/**
* Home object for domain model class TestTable.
* @see .TestTable
* @author Hibernate Tools
*/
@Stateless
public class TestTableHome {

	private static final Log log = LogFactory.getLog(TestTableHome.class);

	@PersistenceContext
	private EntityManager entityManager;

//	@Transactional
	public void persist(TestTable transientInstance) {
		log.debug("persisting TestTable instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TestTable persistentInstance) {
		log.debug("removing TestTable instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TestTable merge(TestTable detachedInstance) {
		log.debug("merging TestTable instance");
		try {
			TestTable result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestTable findById(int id) {
		log.debug("getting TestTable instance with id: " + id);
		try {
			TestTable instance = entityManager.find(TestTable.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/**
	 * update dao (right?) method for the TextCol column
	 */
	public void updateTextcol(int id, String newTextcolVal){
		log.debug("Trying stuff with tryStuff()");
		Session session = null;
        TestTable testTable = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            testTable =  session.get(TestTable.class,new Integer(id));
            Hibernate.initialize(testTable);
            
            Transaction tx = null;
            try {
               tx = session.beginTransaction();
               testTable.setTextCol(newTextcolVal);
               session.save(testTable);
               //SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM TEST_TABLE");
               //Query query = session.createQuery("");
               
               //do some work
               tx.commit();
            }
            catch (Exception e) {
               if (tx!=null) tx.rollback();
               e.printStackTrace(); 
            }finally {
               session.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
	}
	
	/**
	 * simple insert for the TestTable
	 * @param testTable
	 */
	public void insert(TestTable testTable){
		log.debug("entering insert...");
		
	}
	
	
}
