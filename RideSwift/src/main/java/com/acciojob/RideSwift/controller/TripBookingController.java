package com.acciojob.RideSwift.controller;

import com.acciojob.RideSwift.dto.request.TripBookingRequest;
import com.acciojob.RideSwift.dto.response.TripBookingResponse;
import com.acciojob.RideSwift.service.TripBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trip")
@RequiredArgsConstructor
public class TripBookingController {
    private final TripBookingService tripBookingService;

    @PostMapping("/book")
    public ResponseEntity<TripBookingResponse> bookCab(@RequestParam(value = "apply-coupon",
            required = false, defaultValue = "false") boolean applyCoupon,
                                                       @RequestBody TripBookingRequest tripBookingRequest) {
        TripBookingResponse response = tripBookingService.bookCab(applyCoupon,tripBookingRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
