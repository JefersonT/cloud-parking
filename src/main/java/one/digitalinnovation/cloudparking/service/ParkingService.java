package one.digitalinnovation.cloudparking.service;

import one.digitalinnovation.cloudparking.model.Parking;

import java.util.List;

public interface ParkingService {
    List<Parking> findAll();
    Parking findById(Integer id);
    Parking createParking(Parking parking);
    Parking updateParking(Parking parking);
    void deleteParking(Integer id);
}
