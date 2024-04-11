/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package ws;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:PaymentResource [Payment]<br>
 * USAGE:
 * <pre>
 *        Compras client = new Compras();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author diego
 */
public class Compras {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RestPayment/resources";

    public Compras() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Payment");
    }

    public Response purchaseProduct() throws ClientErrorException {
        return webTarget.request().post(null, Response.class);
    }

    public <T> T redirectToPurchasePage(Class<T> responseType, String product) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (product != null) {
            resource = resource.queryParam("product", product);
        }
        return resource.request().get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
