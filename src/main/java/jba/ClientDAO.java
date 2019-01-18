package jba;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ClientDAO {

	public void create(Client c) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		em.persist(c);

		DatabaseHelper.commitTxAndClose(em);
	}

	public void update(Client c) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		em.merge(c);
		
		DatabaseHelper.commitTxAndClose(em);

	}

	public void delete(Client c) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);
		
		Client findClient = em.find(Client.class, c.getId());
		
		if(findClient != null) {
			em.remove(findClient);
		}
		
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void favori(Client c, Book b) {
		
		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);
		
		Client findClient = em.find(Client.class, c.getId());
		
		findClient.setFavbook(b);
		
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public List<Book> livreAchete(Client c) {
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		TypedQuery<Book> query = em.createQuery("select b from Book b inner join b.myClients c where c.id = :id ", Book.class);
		query.setParameter("id", c.getId());
		
		List<Book> books = query.getResultList();

		em.close();
		
		return books;
	}
}
