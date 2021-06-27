package main.java;

import java.util.List;

public class PersonList {

	private List<Person> people;

	public PersonList(List<Person> people) {
		this.people = people;
	}

	public List<Person> getPeople() {
		return people;
	}

	public boolean isPresent(Person p) {
		for(Person person : people) {
			if(person.equals(p)) return true;
		}
		return false;
	}
}
