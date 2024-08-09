package com.acciojob.RideSwift.transformer;

import com.acciojob.RideSwift.model.Coupon;

public class CouponTransformer {
    public static Coupon prepareCoupon(String couponCode, int discount) {
        return Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(discount)
                .build();
    }
}
