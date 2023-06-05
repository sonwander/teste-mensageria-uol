package com.compasso.uol.models.dto;


import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.compasso.uol.models.Product;
import org.hibernate.validator.constraints.Length;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Wanderson Silva
 * @version 1.0.0
 * @since 2023-06-04
 *
 */

@Data
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(position = 0)
    private Long id;

    @ApiModelProperty(position = 1)
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 1, max = 255, message = "O tamanho deve ser entre 1 e 255 caracteres")
    private String name;

    @ApiModelProperty(position = 2)
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 1, max = 255, message = "O tamanho deve ser entre 1 e 255 caracteres")
    private String description;

    @ApiModelProperty(position = 3)
    @NotNull(message = "Preenchimento obrigatório")
    @PositiveOrZero(message = "O preço deve ser um número positivo")
    private Double price;

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
    }
}