package one.digitalinnovation.cloudparking.service.impl;

import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.repository.ParkingRepository;
import one.digitalinnovation.cloudparking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    @Override
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    @Override
    public Optional<Parking> findById(Integer id) {
        return parkingRepository.findById(id);
    }

    @Override
    public void createParking(Parking parking) {
        parkingRepository.save(parking);
    }

    @Override
    public void updateParking(Parking parking) {
        parkingRepository.save(parking);
    }

    @Override
    public void deleteParking(Integer id) {
        parkingRepository.deleteById(id);
    }
}
