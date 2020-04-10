package com.food.service.demo.domain;

import com.food.service.demo.domain.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Food extends BaseEntity {
    private String foodName;
    private int foodPrice;
    private float rating;
}
