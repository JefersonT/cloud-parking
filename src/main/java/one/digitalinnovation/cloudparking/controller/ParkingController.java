package one.digitalinnovation.cloudparking.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.cloudparking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.controller.mapper.ParkingMapper;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Tag(name = "Parking Controller")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private ParkingMapper parkingMapper;

    @GetMapping
    @Operation(summary = "Find All")
    public ResponseEntity<List<ParkingDTO>> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        return ResponseEntity.ok(parkingMapper.toParkingDTOList(parkingList));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find By Id")
    public ResponseEntity<ParkingDTO> findById(@PathVariable Integer id){
        Parking parking = parkingService.findById(id);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }

    @PostMapping
    @Operation(summary = "Create Parking")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
        var parking = parkingMapper.toParkingCreate(dto);
        var parkingCreate = parkingService.createParking(parking);
        var result = parkingMapper.toParkingDTO(parkingCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping
    @Operation(summary = "Update Parking")
    public ResponseEntity<ParkingDTO> update(@RequestBody ParkingDTO dto){
        var parking = parkingMapper.toParking(dto);
        var parkingUpdate =parkingService.updateParking(parking);
        var result = parkingMapper.toParkingDTO(parkingUpdate);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove Parking")
    public ResponseEntity delete(@PathVariable Integer id){
        parkingService.deleteParking(id);
        return ResponseEntity.noContent().build();
    }
}
