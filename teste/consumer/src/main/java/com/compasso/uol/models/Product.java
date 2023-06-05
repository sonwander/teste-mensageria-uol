package com.compasso.uol.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Wanderson Silva
 * @version 1.0.0
 * @since 2023-06-04
 *
 */

@Data
@Document
public class Product {
    @Transient
    public static final String SEQUENCE_NAME = "Id_sequence";

    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
}
