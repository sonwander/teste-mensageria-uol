package com.compasso.uol.resources;

import com.compasso.uol.models.dto.ProductDTO;
import com.compasso.uol.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api(tags = { "Produtos - Producer Rabbitmq" })
@RequestMapping("/api/products")
public class ProductResource {

    private final ProductService productService;

    @PostMapping
    @ApiOperation("Criação de um produto - Produz um registro na fila de forma manual")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Criado com successo"),
                            @ApiResponse(code = 400, message = "Requisição Inválida")})
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO object) {
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                             .buildAndExpand(object.getId()).toUri()).body(productService.insert(object));
    }


    @PostMapping(value = "/auto")
    @ApiOperation("Criação de vários produtos - Produz vários registros para a fila de  processamento de forma automatizada")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Criado com successo"),
            @ApiResponse(code = 400, message = "Requisição Inválida")})
    public ResponseEntity<?> insertAuto() {
                String object = productService.insertAuto();
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                             .buildAndExpand(object).toUri()).body(object);
    }

}