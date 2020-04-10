package com.food.service.demo.domain;

import com.food.service.demo.domain.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class User extends BaseEntity {
    private String userName;
    private int age;
    private String phoneNumber;
    private String address;
}
