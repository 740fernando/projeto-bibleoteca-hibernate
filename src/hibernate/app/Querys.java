package hibernate.app;


import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Livro;

public class Querys {
	
	public static void main(String[] args) throws Exception {
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		{
			String hql="FROM Livro";
			
			Query<Livro> q = session.createQuery(hql); // Retorna um objeto do tipo Query do pacote org.hibernate 
			
			List<Livro> result = q.list();
			
			for(Livro l : result) {
				System.out.println("Nome : "+ l.getNome());
				System.out.println("Autor : "+l.getAutor());
				System.out.println("Editora : "+l.getEditora().getNome());
			}
		}
		
		session.getTransaction().commit();
	}

}
