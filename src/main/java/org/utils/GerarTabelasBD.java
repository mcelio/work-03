package org.utils;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GerarTabelasBD {

	public void gerarTabelas() {
		try {
//			AnnotationConfiguration ac = new AnnotationConfiguration();
//			ac.addAnnotatedClass(Livro.class);
//			ac.addAnnotatedClass(Autorizacao.class);
//			ac.addAnnotatedClass(Usuario.class);
//			sessionFactory = ac.configure().buildSessionFactory();
//			SchemaExport se = new SchemaExport(ac);
//			se.create(true, true);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
