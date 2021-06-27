package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class IO {

	private IO() {

	}

	static PersonList readAttendance(String path) {
		try (Scanner sc = new Scanner(new FileReader(new File(path), StandardCharsets.UTF_16LE))) {
			List<Person> people = new ArrayList<>();
			sc.nextLine();

			String line;
			String[] values;
			try {
				while ((line = sc.nextLine()) != null) {
					try{
						values =  line.split("\t");
						people.add(new Person(values[3], values[4]));
					} catch (Exception e) {}
				}
			} catch (Exception e) {	}
			return new PersonList(people);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static PersonList readPersonList(String path) {
		try (Scanner sc = new Scanner(new FileReader(new File(path), StandardCharsets.UTF_8))) {
			List<Person> people = new ArrayList<>();

			String line;
			String[] values;
			try {
				while ((line = sc.nextLine()) != null) {
					values = line.split(",");
					people.add(new Person(values[0], values[1]));
				}
			} catch (Exception e) {

			}

			return new PersonList(people);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
