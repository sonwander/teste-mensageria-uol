package com.compasso.uol.configs;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Wanderson Silva
 * @version 1.0.0
 * @since 2023-06-04
 *
 */

@Configuration
public class ConsumerRabbitConfig {
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}

