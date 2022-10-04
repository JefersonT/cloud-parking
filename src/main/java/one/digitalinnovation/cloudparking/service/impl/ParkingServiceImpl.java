package one.digitalinnovation.cloudparking.service.impl;

import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.repository.ParkingRepository;
import one.digitalinnovation.cloudparking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private final ParkingRepository parkingRepository;

    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Parking findById(Integer id) {
        return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
    }

    @Override
    @Transactional
    public Parking createParking(Parking parking) {
        parking.setEntryDate(LocalDateTime.now());
        return parkingRepository.save(parking);
    }

    @Override
    @Transactional
    public Parking updateParking(Parking parking) {
        return parkingRepository.save(parking);
    }

    @Override
    @Transactional
    public Parking exit(Integer id) {
        Parking parking = parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id) );
        parking.setExitDate(LocalDateTime.now());
        var bill = 1.0;
        var hours = parking.getExitDate().getHour() - parking.getEntryDate().getHour();
        if (hours >= 1){
            bill += (hours * 60) * 0.2;
        }
        parking.setBill(bill);
        return parkingRepository.save(parking);
    }

    @Override
    @Transactional
    public void deleteParking(Integer id) {
        parkingRepository.deleteById(id);
    }
}
