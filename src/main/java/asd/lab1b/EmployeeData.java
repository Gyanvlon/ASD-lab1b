package asd.lab1b;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Daniel", "Agar", "2018-01-17", 105945.50, new PensionPlan("EX1089", "2023-01-17", 100.00)));
        employees.add(new Employee(2, "Benard", "Shaw", "2019-04-03", 197750.00, null));
        employees.add(new Employee(3, "Carly", "Agar", "2014-05-16", 842000.75, new PensionPlan("SM2307", "2019-11-04", 1555.50)));
        employees.add(new Employee(4, "Wesley", "Schneider", "2019-09-02", 74500.00, null));
        return employees;
    }
}
