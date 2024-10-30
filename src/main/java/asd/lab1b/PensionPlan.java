package asd.lab1b;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionPlan {
    private String planReferenceNumber;
    private String enrollmentDate;
    private double monthlyContribution;
}
