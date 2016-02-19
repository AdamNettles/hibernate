package util;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.annotations.*;

import pojo.TestTable;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().addPackage("pojo") // the fully qualified package name
					.addAnnotatedClass(TestTable.class)
					// .addResource("test/animals/orm.xml")
//					.configure("hibernate.cfg.xml")
					.configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	//
	// static {
	// try {
	// // Create the SessionFactory from hibernate.cfg.xml
	// sessionFactory = new Configuration().configure().buildSessionFactory();
	// } catch (Throwable ex) {
	// // Make sure you log the exception, as it might be swallowed
	// System.err.println("Initial SessionFactory creation failed." + ex);
	// throw new ExceptionInInitializerError(ex);
	// }
	// }
	//
	// public static SessionFactory getSessionFactory() {
	// return sessionFactory;
	// }

}
