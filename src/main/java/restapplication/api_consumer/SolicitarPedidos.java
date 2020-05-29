/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restapplication.api_consumer;

import com.fasterxml.jackson.core.JsonProcessingException;

import entidades.Cliente;
import entidades.Ordenventa;
import entidades.Producto;
import entidades.Ventadetalle;
import entidades.VentadetallePK;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;

/**
 *
 * @author jcami
 */
public class SolicitarPedidos {

    public static void main(String[] args) throws JsonProcessingException {
        /*Ordenventa ordenventa = pruebaGenerarPedido();
        System.out.println(ordenventa);
        Response response = pruebaAgregarDetallesAlPedido(ordenventa);
        System.out.println("Solicitando pedido...");
        Response responseSolicitar = APIConsumerMercado.concluirPedido(ordenventa);
        System.out.println("Respuesta: "+responseSolicitar.getStatus());*/
        try {
            ArrayList<Ventadetalle> detalles = new ArrayList<>();
            for(long i=40; i<42; i++){
                Producto producto = new Producto();
                producto.setProductoid(i);
                Ventadetalle ventadetalle = new Ventadetalle();
                ventadetalle.setProducto(producto);
                ventadetalle.setCantidad(10);
                detalles.add(ventadetalle);
            }
            Ordenventa ordenventa = APIConsumerMercado.generarPedidoCompleto("Realizando prueba de solicitud de productos", detalles);
            System.out.println(ordenventa);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(SolicitarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Ordenventa pruebaGenerarPedido() {
        Ordenventa ordenventa = new Ordenventa();
        Cliente cliente = new Cliente();
        cliente.setEmail("compras@supermercado.com");
        ordenventa.setClienteid(cliente);
        ordenventa.setDescripcion("Orden de venta. Supermercado - proveedor");
        //agregarDetallesAlPedido(ordenventa, detalles);
        System.out.println("Realizando pedido...");
        Response responseOrdenVenta = APIConsumerMercado.realizarPedido(ordenventa);
        System.out.println("Respuesta: "+responseOrdenVenta.getStatus());
        if(responseOrdenVenta.getStatus()!=200){
            return null;
        }
        Ordenventa entityResult = responseOrdenVenta.readEntity(Ordenventa.class);
        return entityResult;
    }
    
    public static Response pruebaAgregarDetallesAlPedido(Ordenventa ordenventa){
        System.out.println("Haciendo petición POST para insertar los detalles de la orden...");
        ArrayList<Ventadetalle> ventadetalleList = new ArrayList<>();
        for(long i=7; i<9; i++){
            Producto producto = new Producto();
            producto.setProductoid(i);
            Ventadetalle ventadetalle = new Ventadetalle(new VentadetallePK(ordenventa.getOrdenventaid(), producto.getProductoid()));
            ventadetalle.setOrdenventa(ordenventa);
            ventadetalle.setProducto(producto);
            ventadetalle.setCantidad(100);
            ventadetalleList.add(ventadetalle);
        }
        ordenventa.setVentadetalleCollection(ventadetalleList);
        Response responseDetalles = APIConsumerMercado.agregarDetallesAlPedido(ordenventa);
        System.out.println("Respuesta: "+responseDetalles.getStatus());
        return responseDetalles;
    }
    
}

