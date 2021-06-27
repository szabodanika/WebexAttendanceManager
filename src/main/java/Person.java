package main.java;

public class Person {

	private String name, email;

	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "%-30s %-30s".formatted(name, email);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if(email.equalsIgnoreCase(person.email)){
			int i = 1;
		}
		return email.equals(person.email);
	}

	@Override
	public int hashCode() {
		return email != null ? email.hashCode() : 0;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
