package jba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookDAO {

	public void create(Book b) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		em.persist(b);

		DatabaseHelper.commitTxAndClose(em);
	}

	public void update(Book b) {
		
		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		em.merge(b);
		
		DatabaseHelper.commitTxAndClose(em);
	}

	public void delete(Book b) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);
		
		Book findBook = em.find(Book.class, b.getId());
		
		if(findBook != null) {
			em.remove(findBook);
		}
		
		DatabaseHelper.commitTxAndClose(em);
	}
}
