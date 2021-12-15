package hibernate.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Cliente;
import entities.Editora;
import entities.Livro;
import entities.RG;


public class Application {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		Cliente c = new Cliente();
		
		c.setNome("Fernando");
		session.save(c);
		
		RG rg = new RG();
		rg.setNumero("123456");
		rg.setDataExpedicao(new Date());
		rg.setCliente(c);
		session.save(rg);
		
		Editora e = new Editora();
		e.setNome("Editora Abril");
		session.save(e);
		
		Livro l = new Livro();
		l.setNome("JAVA");
		l.setAutor(" JAVA SENTIOR");
		l.setIsbn("CHAVEPRIMARIACRIADA");
		l.setEditora(e);
		session.save(l);
		
		l.getClientes().add(c);
		
		
		session.getTransaction().commit();
	}
}
