/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class notificaciones {
     static String QUEUE_NAME = "ListaCompra";
      private Channel channel;
    public notificaciones() {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        
         try {
             Connection connection = (Connection) factory.newConnection();
              channel = connection.createChannel();
         } catch (IOException ex) {
             Logger.getLogger(notificaciones.class.getName()).log(Level.SEVERE, null, ex);
         } catch (TimeoutException ex) {
             Logger.getLogger(notificaciones.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void enviarNotificacionComprar(String compra) {
        
        try {
            
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, compra.getBytes());
            System.out.println("[x] Sent '" + compra + "'");

        } catch (Exception ex) {
            
            System.out.println(ex);
            
        } 
    }
}