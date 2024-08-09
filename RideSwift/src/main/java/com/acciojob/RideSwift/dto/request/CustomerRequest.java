package com.acciojob.RideSwift.dto.request;

import com.acciojob.RideSwift.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {
    String name;
    int age;
    String emailId;
    String address;
    Gender gender;
}
