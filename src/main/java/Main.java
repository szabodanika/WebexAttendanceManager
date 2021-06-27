package main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	static String personsListFile, attendanceReportFile;
	static PersonList attendanceSheet, personList;


	public static void main(String[] args) {

		File groupsDir = new File("./data/groups");
		List<String> groups = new ArrayList<>();
		for (File file : groupsDir.listFiles()) {
			groups.add(file.getName().replace(".csv", ""));
		}

		for (String group : groups) {
			String report = "";
			List<String> webexReports = new ArrayList<>();
			File webexDir = new File("./data/webex/" + group);
			personList = IO.readPersonList("./data/groups/" + group + ".csv");

			for (File file : webexDir.listFiles()) {
				webexReports.add(file.getName().replace(".csv", ""));
			}


			for (String webexReport : webexReports) {
				attendanceSheet = IO.readAttendance("./data/webex/" + group + "/" + webexReport + ".csv");
				List<Person> present = new ArrayList<>();
				List<Person> absent = new ArrayList<>();
				List<Person> unknown = new ArrayList<>();

				for (Person p : personList.getPeople()) {
					if (attendanceSheet.isPresent(p)) {
						present.add(p);
					} else {
						absent.add(p);
					}
				}
				for (Person p : attendanceSheet.getPeople()) {
					if (!personList.isPresent(p)) {
						unknown.add(p);
					}
				}

				report += """
						Report: %s
						Present: %s
						Absent: %s
						Unrecognized: %s
												
						""".formatted(
						webexReport,
						present.stream().map(person -> person.getName()).collect(Collectors.joining(",")),
						absent.stream().map(person -> person.getName()).collect(Collectors.joining(",")),
						unknown.stream().map(person -> person.getName()).collect(Collectors.joining(","))
				);
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./data/attendance/" + group + ".txt")))) {
				writer.write(report);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

}
