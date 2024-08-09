package com.acciojob.RideSwift.repository;

import com.acciojob.RideSwift.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {
}
