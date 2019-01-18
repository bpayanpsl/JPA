package jba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book b1 = new Book("titre1", "auteur1");	
		Client c1 = new Client("lastname1", "firstname1", "M");
		
		Book b2 = new Book("titre2", "auteur2");
		Client c2 = new Client("lastname2", "firstname2", "F");
		
		ClientDAO cdao = new ClientDAO();
		BookDAO bdao = new BookDAO();
		
		cdao.create(c2);
		bdao.create(b2);
		
		cdao.favori(c2, b2);
		c2.achat(b2);
		cdao.update(c2);
		
		for (Book b : cdao.livreAchete(c2)) {
			System.out.println(b2.toString());
		}
		
		//cdao.delete(c2);
		
		//c2.setLastname("gtfghdh");
		//cdao.update(c2);

		/*em = emf.createEntityManager();
		Book findBook = em.find(Book.class, b1.getId());
		System.out.println(findBook.getId() + " " + findBook.getTitle() + " " + findBook.getAuthor());
		em.close();*/

	}

}
