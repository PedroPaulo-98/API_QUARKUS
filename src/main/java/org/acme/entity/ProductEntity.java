package org.acme.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Product")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductEntity {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    private String category;

    private String model;

    private BigDecimal price;

}
