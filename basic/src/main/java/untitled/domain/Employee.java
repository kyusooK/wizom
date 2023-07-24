package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.BasicApplication;

@Entity
@Table(name = "Employee_table")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    @Embedded
    @AttributeOverride(
        name = "id",
        column = @Column(name = "rankIdId", nullable = true)
    )
    private RankId rankId;

    @ElementCollection
    private List<Adress> adresses;

    public static EmployeeRepository repository() {
        EmployeeRepository employeeRepository = BasicApplication.applicationContext.getBean(
            EmployeeRepository.class
        );
        return employeeRepository;
    }
}
