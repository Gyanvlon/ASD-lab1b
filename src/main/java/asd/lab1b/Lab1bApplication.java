package asd.lab1b;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Lab1bApplication implements CommandLineRunner {

    public static void printAllEmployees(List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getLastName)
                .thenComparing(Comparator.comparingDouble(Employee::getYearlySalary).reversed()));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    public static void printUpcomingEnrollees(List<Employee> employees) {
        LocalDate now = LocalDate.now();
        LocalDate nextMonthStart = now.plusMonths(1).withDayOfMonth(1);
        LocalDate nextMonthEnd = nextMonthStart.withDayOfMonth(nextMonthStart.lengthOfMonth());

        List<Employee> upcomingEnrollees = employees.stream()
                .filter(e -> e.getPensionPlan() == null)  // Not enrolled
                .filter(e -> LocalDate.parse(e.getEmploymentDate()).plusYears(5).isAfter(nextMonthStart) &&
                        LocalDate.parse(e.getEmploymentDate()).plusYears(5).isBefore(nextMonthEnd))
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .collect(Collectors.toList());
        System.out.println(upcomingEnrollees);
    }
    public static void main(String[] args) {
        SpringApplication.run(Lab1bApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Original Employee Data: ");
        for (Employee employee : EmployeeData.loadEmployees()) {
            System.out.println(employee);
        }
        System.out.println("Sorted in ascending order of the Employees’ Last Names and descending order of their Yearly salaries: ");
        printAllEmployees(EmployeeData.loadEmployees());
        System.out.println("Monthly Upcoming Enrollees ");
        printUpcomingEnrollees(EmployeeData.loadEmployees());
    }
}
