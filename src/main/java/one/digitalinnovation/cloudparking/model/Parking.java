package one.digitalinnovation.cloudparking.model;

import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String license;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;

    @Column(columnDefinition = "Decimal(10,2)")
    private Double bill;
}
