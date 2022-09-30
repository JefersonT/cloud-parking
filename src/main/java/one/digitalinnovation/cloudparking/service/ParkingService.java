package one.digitalinnovation.cloudparking.service;

import one.digitalinnovation.cloudparking.model.Parking;

import java.util.List;
import java.util.Optional;

public interface ParkingService {
    List<Parking> findAll();
    Optional<Parking> findById(Integer id);
    void createParking(Parking parking);
    void updateParking(Parking parking);
    void deleteParking(Integer id);
}
