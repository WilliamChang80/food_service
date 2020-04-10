package com.food.service.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.food.service.demo.domain.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Receipt extends BaseEntity {
    @OneToOne
    private User user;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date receiptDate;

    private int receiptPrice;

    @Enumerated
    private OrderStatus receiptStatus;

    @OneToOne
    private Store store;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Food> food;
}
