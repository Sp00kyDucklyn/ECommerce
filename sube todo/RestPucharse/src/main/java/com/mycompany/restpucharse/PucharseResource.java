/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.restpucharse;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import rabbit.notificaciones;
import ws.Compras;

/**
 * REST Web Service
 *
 * @author diego
 */
@Path("pucharse")
@RequestScoped
public class PucharseResource {

    @Context
    private UriInfo context;
    
    private notificaciones noti;

    
    /**
     * Creates a new instance of PucharseResource
     */
    public PucharseResource() {
       
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.restpucharse.PucharseResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response enviarCompra(String compra) {
        
        compra=compra.strip();
        String[] parts = compra.split("=");
        String purchaseInput = "";
        if (parts.length == 2) {
            purchaseInput = parts[1];
        }
        noti = new notificaciones();
        noti.enviarNotificacionComprar(purchaseInput);
        Compras n= new Compras();
        Response response = n.redirectToPurchasePage(Response.class,purchaseInput);

        // Retornar la respuesta recibida del otro recurso
        System.out.println(response);
        return response;
       
         
    }

    /**
     * PUT method for updating or creating an instance of PucharseResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
