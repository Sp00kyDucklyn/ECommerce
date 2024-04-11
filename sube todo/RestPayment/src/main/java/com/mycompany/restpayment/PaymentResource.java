/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.restpayment;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

/**
 * REST Web Service
 *
 * @author diego
 */
@Path("Payment")
@RequestScoped
public class PaymentResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PaymentResource
     */
    public PaymentResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.restpayment.PaymentResource
     * @return an instance of java.lang.String
     */
    @GET
    public Response redirectToPurchasePage(@QueryParam("product") String productName) {
        // Redirigir al usuario al formulario de compra con el producto seleccionado
       String baseUri = context.getBaseUriBuilder()
                                .replacePath("/RestPayment/compra.html") // Reemplazar la ruta a compra.html
                                .build()
                                .toString();
        
        // Redirigir al usuario a compra.html con el producto seleccionado
        return Response.seeOther(UriBuilder.fromUri(baseUri)
                .queryParam("product", productName)
                .build())
                .build();
    }

    @POST
    public Response purchaseProduct(String productName) {
        // Lógica para procesar la compra
        return Response.ok("Compra realizada con éxito").build();
    }
}
