package asd.lab1b;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;
}
