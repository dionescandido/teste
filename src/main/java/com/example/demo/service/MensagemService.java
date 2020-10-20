package com.example.demo.service;


import com.example.demo.domain.Pedido;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class MensagemService {

    public static void main(String[] args) throws Exception {
        String uri = System.getenv("CLOUDAMQP_URL");
        if (uri == null) uri = "amqp://admin:admin@localhost";

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(uri);

        //Recommended settings
        factory.setRequestedHeartbeat(30);
        factory.setConnectionTimeout(30000);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        String queue = "hello";
        boolean durable = false;
        boolean exclusive = false;
        boolean autoDelete = false;

        channel.queueDeclare(queue, durable, exclusive, autoDelete, null);
        String message = "Hello CloudAMQP!";

        String exchangeName = "";
        String routingKey = "hello";
        channel.basicPublish(exchangeName, routingKey, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queue, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        }
    }


}
