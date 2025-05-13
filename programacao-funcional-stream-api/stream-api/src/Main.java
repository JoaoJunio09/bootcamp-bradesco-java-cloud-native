import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();
        System.out.print("Enter salary: ");
        Double salary = sc.nextDouble();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while(line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            Comparator<Employee> comp = (e1, e2) -> e1.getEmail().toUpperCase().compareTo(e2.getEmail().toUpperCase());

            List<String> emailOfEmployees = list.stream()
                    .filter(e -> e.getSalary() > salary)
                    .sorted(comp)
                    .map(e -> e.getEmail())
                    .collect(Collectors.toList());

            System.out.println("Email of people whose salary is more than " + salary + ":");
            emailOfEmployees.forEach(System.out::println);

            double sumSalarys = list.stream()
                    .filter(e -> e.getName().charAt(0) == 'M')
                    .map(e -> e.getSalary())
                    .reduce(0.0, (x,y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " + sumSalarys);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}