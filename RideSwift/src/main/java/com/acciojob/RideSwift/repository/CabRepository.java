package com.acciojob.RideSwift.repository;

import com.acciojob.RideSwift.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CabRepository extends JpaRepository<Cab,Integer> {
    @Query(value = "select * from cab where available = true order by rand() limit 1",nativeQuery = true)
    Cab getRandomAvailableCab();
}
