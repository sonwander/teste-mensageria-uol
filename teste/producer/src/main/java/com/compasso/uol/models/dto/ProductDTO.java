package com.compasso.uol.models.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import com.compasso.uol.models.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author Wanderson Silva
 * @version 1.0.0
 * @since 2021-05-25
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(position = 0)
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(position = 1)
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 1, max = 255, message = "O tamanho deve ser entre 1 e 255 caracteres")
    private String name;

    @Column(nullable = false)
    @ApiModelProperty(position = 2)
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 1, max = 255, message = "O tamanho deve ser entre 1 e 255 caracteres")
    private String description;

    @Column(nullable = false)
    @ApiModelProperty(position = 3)
    @NotNull(message = "Preenchimento obrigatório")
    @PositiveOrZero(message = "O preço deve ser um número positivo")
    private Double price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}