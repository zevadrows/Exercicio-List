package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();

		List<Employee> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			list.add(new Employee(id, name, salary));
		}

		System.out.print("Enter the employee id that will have salary increase: ");
		int idEmp = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == idEmp).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextInt();
			emp.raise((int)percentage);
		}
		
		/*
		 * OPCIONAL
		List<Employee> result = list.stream().filter(x -> x.getId() == idEmp).collect(Collectors.toList());
		if (result.isEmpty()) {
			System.out.println("This id does now exist!");
		} else {
			for (Employee employee : result) {

				if (employee.getId() == idEmp) {
					System.out.print("\nEnter the percentage: ");
					double perc = sc.nextInt();
					employee.raise((int) perc);
				}
			}
		 
		}
		 */
		System.out.println("List of employees:");
		for (Object obj : list) {
			list.indexOf(obj);
			System.out.println(obj);
		}
		sc.close();

	}

}
