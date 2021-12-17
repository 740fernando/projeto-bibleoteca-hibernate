package hibernate.app;


import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Cliente;
import entities.Livro;
import entities.RG;

public class Querys {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
//		{    LISTA DE LIVROS POR NOME,AUTOR E NOME DA EDITORA
//			String hql="FROM Livro";
//			
//			Query<Livro> q = session.createQuery(hql); // Retorna um objeto do tipo Query do pacote org.hibernate 
//			
//			List<Livro> result = q.list();
//			
//			for(Livro l : result) {
//				System.out.println("Nome : "+ l.getNome());
//				System.out.println("Autor : "+l.getAutor());
//				System.out.println("Editora : "+l.getEditora().getNome());
//			}
//		}
		
//		{		LISTA DE LIVROS CODIGO E NOME
//			String hql  =" SELECT l.isbn,l.nome From Livro l";
//			Query q = session.createQuery(hql);
//			List<Object[]> result = q.list();
//			
//			for(Object[] obj : result) {
//				System.out.println("ISBN: "+obj[0]);
//				System.out.println("Nome: "+obj[1]);
//			}
////LISTA DE Livros Emprestado
//		{
//			String hql = "SELECT c FROM Cliente c INNER JOIN c.livros l";
//			Query q = session.createQuery(hql);
//			List<Cliente> result = q.list();
//			
//			for (Cliente c : result) {
//				System.out.println("Nome:" + c.getNome());
//				System.out.println("RG: " + c.getRg().getNumero());
//			}
//		}
//		{
//			String hql = "SELECT l FROM Livro l WHERE l.editora.nome='Editora 1'";
//			Query q = session.createQuery(hql);
//			List<Livro> result = q.list();
//			
//			for(Livro l : result ) {
//				System.out.println("Nome "+l.getNome());
//			}
//		}
		
		{
			String hql = "Select r From RG r WHERE r.cliente.nome LIKE 'C%'";
			Query q = session.createQuery(hql);
			List<RG> result = q.list();
			
			for(RG rg: result) {
				System.out.println("N : "+rg.getNumero());
			}
			
		}
		
		session.getTransaction().commit();
	}
}
