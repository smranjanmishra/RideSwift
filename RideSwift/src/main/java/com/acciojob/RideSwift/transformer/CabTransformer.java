package com.acciojob.RideSwift.transformer;

import com.acciojob.RideSwift.dto.request.CabRequest;
import com.acciojob.RideSwift.dto.response.CabResponse;
import com.acciojob.RideSwift.model.Cab;

public class CabTransformer {
    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNo(cabRequest.getCabNo())
                .carModel(cabRequest.getCarModel())
                .farePerKm(cabRequest.getFarePerKm())
                .numberOfSeats(cabRequest.getNumberOfSeats())
                .carType(cabRequest.getCarType())
                .available(true)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab){
        return CabResponse.builder()
                .cabNo(cab.getCabNo())
                .carModel(cab.getCarModel())
                .farePerKm(cab.getFarePerKm())
                .build();
    }
}
