/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *
 * @author diego
 */
public class notificaciones {
     static String QUEUE_NAME = "ListaCompra";
    public notificaciones() {

    }

    public void enviarNotificacionComprar(String compra) {
        
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");

        try {
            Connection connection = (Connection) factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                channel.basicPublish("", QUEUE_NAME, null, compra.getBytes());
                System.out.println("[x] Sent '" + compra + "'");

        } catch (Exception ex) {
            
            System.out.println(ex);
            
        } 
    }
}