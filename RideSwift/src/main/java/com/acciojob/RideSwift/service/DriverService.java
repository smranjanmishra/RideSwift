package com.acciojob.RideSwift.service;

import com.acciojob.RideSwift.dto.request.DriverRequest;
import com.acciojob.RideSwift.model.Cab;
import com.acciojob.RideSwift.model.Driver;
import com.acciojob.RideSwift.repository.DriverRepository;
import com.acciojob.RideSwift.transformer.CabTransformer;
import com.acciojob.RideSwift.transformer.DriverTransformer;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    //    @Autowired
    //    DriverRepository driverRepository;

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public String addDriver(DriverRequest driverRequest) {

        // driver request -> driver
        // cab Request -> cab
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCab());

        // set the relationship attributrs
        driver.setCab(cab);
        cab.setDriver(driver);

        driverRepository.save(driver);  // save both driver and cab
        return "Driver and Cab saved successfully";

    }

    public Driver getDriver(String mobNo) {
        return driverRepository.findByMobNo(mobNo);
    }
}
