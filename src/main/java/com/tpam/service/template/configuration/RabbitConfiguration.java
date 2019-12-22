package com.tpam.service.template.configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@Configuration
@EnableTransactionManagement
public class RabbitConfiguration {

   // @Autowired
    //protected RabbitTemplate rabbitTemplate;

    //@Bean
    public RabbitTransactionManager rabbitTransactionManager(ConnectionFactory connectionFactory) {
        return new RabbitTransactionManager(connectionFactory);
    }

    //@Bean
    //public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
      //  return new RabbitAdmin(connectionFactory);
   // }

    //@PostConstruct
    //protected void init() {
        // make rabbit template to support transactions
    //    rabbitTemplate.setChannelTransacted(true);
    //}
}