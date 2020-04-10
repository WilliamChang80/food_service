package com.food.service.demo.domain;

import com.food.service.demo.domain.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@NoArgsConstructor
public class Store extends BaseEntity {
    private String storeName;
    private String storeAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Food> food;
}
