package one.digitalinnovation.cloudparking.controller;

import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.controller.mapper.ParkingMapper;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private ParkingMapper parkingMapper;

    @GetMapping
    public List<ParkingDTO> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        return parkingMapper.toParkingDTOList(parkingList);
    }

    @GetMapping("/{id}")
    public ParkingDTO findById(@PathVariable Integer id){
        Parking parking = parkingService.findById(id).orElse(null);
        return parkingMapper.parkingDTO(parking);
    }

    @PostMapping
    public void create(@RequestBody Parking parking){
        parkingService.createParking(parking);
    }

    @PutMapping
    public void update(@RequestBody Parking parking){
        parkingService.updateParking(parking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        parkingService.deleteParking(id);
    }
}
