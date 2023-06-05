package com.compasso.uol.services;

import com.compasso.uol.constants.Constants;
import com.compasso.uol.models.Product;
import com.compasso.uol.models.dto.ProductDTO;
import com.compasso.uol.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private final ProductRepository productRepository;

    private void sendMessageQueue(ProductDTO product){
        try {
            rabbitTemplate.convertAndSend(Constants.EXCHANGE_1, Constants.ROUTING_KEY_1, product);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public ProductDTO insert(ProductDTO object) {
        Product product = new Product();
                product.setName(object.getName());
                product.setDescription(object.getDescription());
                product.setPrice(object.getPrice());
                product = productRepository.save(product);
                sendMessageQueue(new ProductDTO(product));
        return new ProductDTO(product);
    }


    @Transactional
    public String insertAuto() {
            for (int i=0; i < 1000; i++) {
                Product product = new Product();
                        product.setName("Nome " + i++ + " produto " + i++);
                        product.setDescription("Uma descrição " + i++ + " de um produto teste " + i++ + " gerado pelo PRODUCER-RABBITMQ de forma automática " + i++);
                        product.setPrice(i++ * 3.50);
                        product = productRepository.save(product);
                        sendMessageQueue(new ProductDTO(product));
                System.out.println(product);
            }
        return "Registros inseridos na fila com sucesso";
    }

}
