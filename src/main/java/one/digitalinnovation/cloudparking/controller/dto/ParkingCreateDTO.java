package one.digitalinnovation.cloudparking.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingCreateDTO {
    private String license;
    private String state;
    private String model;
    private String color;
}
