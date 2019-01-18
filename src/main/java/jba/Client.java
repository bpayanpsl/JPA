package jba;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String lastname;
	
	@Column
	private String firstname;
	
	@Column
	private String gender;
	
	@ManyToOne
	private Book favbook;
	
	@ManyToMany
	private List<Book> myBooks;

	public Client() {
		super();
	}

	public Client(String l, String f, String g) {
		lastname = l;
		firstname = f;
		gender = g;
		myBooks = new ArrayList<>();
	}
	
	public void achat(Book b) {
		this.myBooks.add(b);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Book getFavbook() {
		return favbook;
	}

	public void setFavbook(Book favbook) {
		this.favbook = favbook;
	}
}
