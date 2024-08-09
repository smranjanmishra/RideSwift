package com.acciojob.RideSwift.controller;

import com.acciojob.RideSwift.dto.request.DriverRequest;
import com.acciojob.RideSwift.model.Driver;
import com.acciojob.RideSwift.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<String> addDriver(@RequestBody DriverRequest driverRequest) {
        String response = driverService.addDriver(driverRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/mob-no/{mob-no}")
    public Driver getDriver(@PathVariable("mob-no") String mobNo) {
        return driverService.getDriver(mobNo);
    }
}
