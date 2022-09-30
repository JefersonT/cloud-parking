package one.digitalinnovation.cloudparking.service.impl;

import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.repository.ParkingRepository;
import one.digitalinnovation.cloudparking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    @Override
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    @Override
    public Parking findById(Integer id) {
        Parking parking = parkingRepository.findById(id).orElse(null);
        if (parking == null){
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    @Override
    public Parking createParking(Parking parking) {
        parking.setEntryDate(LocalDateTime.now());
        return parkingRepository.save(parking);
    }

    @Override
    public Parking updateParking(Parking parking) {
        return parkingRepository.save(parking);
    }

    @Override
    public void deleteParking(Integer id) {
        parkingRepository.deleteById(id);
    }
}
