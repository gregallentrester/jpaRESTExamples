package net.greg.jparest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	public String getFirstName() { return firstName; }
	public void setFirstName(String value) { firstName = value; }

	private String lastName;
	public String getLastName() { return lastName; }
	public void setLastName(String value) { lastName = value; }
}
