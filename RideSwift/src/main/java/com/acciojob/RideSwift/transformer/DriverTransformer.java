package com.acciojob.RideSwift.transformer;

import com.acciojob.RideSwift.dto.request.DriverRequest;
import com.acciojob.RideSwift.dto.response.DriverResponse;
import com.acciojob.RideSwift.model.Driver;

public class DriverTransformer {
    public static Driver driverRequestToDriver(DriverRequest driverRequest) {
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .mobNo(driverRequest.getMobNo())
                .rating(0)
                .panNumber(driverRequest.getPanNumber())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver) {
        return DriverResponse.builder()
                .name(driver.getName())
                .rating(driver.getRating())
                .mobNo(driver.getMobNo())
                .cabResponse(CabTransformer.cabToCabResponse(driver.getCab()))
                .build();
    }
}
