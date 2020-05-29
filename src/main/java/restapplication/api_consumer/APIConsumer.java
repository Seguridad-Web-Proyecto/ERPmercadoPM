/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restapplication.api_consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entidades.Categoria;
import entidades.Ordenventa;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.client.ClientBuilder;

import static restapplication.api_consumer.ClienteHTTP.peticionHttpGet;
import restapplication.pojos.ProductoPOJO;

/**
 *
 * @author jcami
 */
public class APIConsumer {
    
    private static final String pathProductos = "http://localhost:8080/ERPproveedoresPM/webresources/productos";
    private static final String pathCategorias = "http://localhost:8080/ERPproveedoresPM/webresources/categorias";
    
    private static final String USER_AGENT = "Mozilla/5.0";
    
    public static List<ProductoPOJO> productos(String path){
        System.out.println("Solicitando productos Mercado -> Proveedor");
        List<ProductoPOJO> productoList = new ArrayList<>();
        String url = pathProductos+path;
        String respuesta = "";
        try {
            respuesta = peticionHttpGet(url);
            System.out.println("La respuesta es:\n" + respuesta);
            String jsonString = new String(respuesta.getBytes("ISO-8859-1"), "UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            productoList = mapper.readValue(jsonString, new TypeReference<List<ProductoPOJO>>(){});
//            for(Producto p: productoList){
//                System.out.println("-------------------");
//                System.out.println("productoid: "+p.getProductoid());
//                System.out.println("nombre: "+p.getNombre());
//                System.out.println("descripcion: "+p.getDescripcion());
//                System.out.println("unidad de medida: "+p.getUnidadMedida());
//                System.out.println("categoría[ ");
//                System.out.println("categoriaid: "+p.getCategoriaid());
//                System.out.println("categoría nombre: "+p.getCategoriaid().getNombre());
//                System.out.println("]\n-------------------");
//            }
        } catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }
        return productoList;
    }
    
    public static void getProductosMercado(){
        System.out.println("Solicitando productos a mí mismo");
        clientHttp = ClientBuilder.newClient();
        webTarget = clientHttp.target("http://localhost:8080/ERPmercadoPM/webresources/productos").path("/17");
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        System.out.println("Respuesta: "+response.getStatus());
        try {
            String responseString = response.readEntity(String.class);
            Producto producto = new ObjectMapper().
                    readValue(responseString, new TypeReference<Producto>(){});
            System.out.println(producto);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(APIConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProductoPOJO obtenerProductoXId(Long productoid){
        System.out.println("Solicitando producto "+productoid+" Mercado -> Proveedor");
        String url = pathProductos+"/"+productoid.toString();
        String respuesta = "";
        ProductoPOJO productoPOJO= new ProductoPOJO();
        try {
            respuesta = peticionHttpGet(url);
            System.out.println("La respuesta es:\n" + respuesta);
            String jsonString = new String(respuesta.getBytes("ISO-8859-1"), "UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            productoPOJO = mapper.readValue(jsonString, new TypeReference<ProductoPOJO>(){});
//            System.out.println("-------------------");
//            System.out.println("productoid: "+productoPOJO.getProductoid());
//            System.out.println("nombre: "+productoPOJO.getNombre());
//            System.out.println("descripcion: "+productoPOJO.getDescripcion());
//            System.out.println("unidad de medida: "+productoPOJO.getUnidadMedida());
//            System.out.println("categoría[ ");
//            System.out.println("categoriaid: "+productoPOJO.getCategoriaid());
//            System.out.println("categoría nombre: "+productoPOJO.getCategoriaid().getNombre());
//            System.out.println("]\n-------------------");
        } catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }
        return productoPOJO;
    }
    
    public static List<Categoria> categorias(String path){
        List<Categoria> categoriaList = new ArrayList<>();
        String url = pathCategorias+path;
        String respuesta = "";
        try {
            respuesta = peticionHttpGet(url);
            System.out.println("La respuesta es:\n" + respuesta);
            String jsonString = new String(respuesta.getBytes("ISO-8859-1"), "UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            categoriaList = mapper.readValue(jsonString, new TypeReference<List<Categoria>>(){});
            for(Categoria categoria: categoriaList){
                System.out.println("-------------------");
                System.out.println("categoría[ ");
                System.out.println("categoriaid: "+categoria.getCategoriaid());
                System.out.println("categoría nombre: "+categoria.getNombre());
                System.out.println("]\n-------------------");
            }
        } catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }
        return categoriaList;
    }
    
    public static Categoria obtenerCategoriaXId(Long categoriaid){
        String url = pathCategorias+"/"+categoriaid.toString();
        String respuesta = "";
        Categoria categoria = new Categoria();
        try {
            respuesta = peticionHttpGet(url);
            String jsonString = new String(respuesta.getBytes("ISO-8859-1"), "UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            categoria = mapper.readValue(jsonString, new TypeReference<Categoria>(){});
            System.out.println("-------------------");
            System.out.println("categoria[ ");
            System.out.println("categoriaid: "+categoria.getCategoriaid());
            System.out.println("categoría nombre: "+categoria.getNombre());
            System.out.println("]\n-------------------");
        } catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }
        return categoria;
    }
    
    public static String productosCOUNT(){
        String url = pathProductos+"/count";
        String respuesta="";
        try{
            respuesta = peticionHttpGet(url);
        }catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public static String categoriasCOUNT(){
        String url = pathCategorias+"/count";
        String respuesta="";
        try{
            respuesta = peticionHttpGet(url);
        }catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }
        return respuesta;
    }
    
    private static final String URL_BASE = "http://localhost:8080/ERPproveedoresPM/webresources";
    private static WebTarget webTarget;
    private static Client clientHttp;
    private static Invocation.Builder invocationBuilder;
    
    public static Response realizarPedido(Ordenventa ordenventa){
        System.out.println("Mercado -> Realizando pedido a proveedores...");
        clientHttp = ClientBuilder.newClient();
        webTarget = clientHttp.target(URL_BASE).path("/pedidos");
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(
                Entity.entity(ordenventa, MediaType.APPLICATION_JSON));
        System.out.println("Respuesta: "+response.getStatus());
        return response;
    }
    
    public static Response agregarDetallesAlPedido(Ordenventa ordenventa){
        System.out.println("Proveedores -> Agregando detalles al pedido");
        if(ordenventa.getVentadetalleCollection()==null) return null;
        clientHttp = ClientBuilder.newClient();
        webTarget = clientHttp.target(URL_BASE).path("/pedidos/detalles");
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.put(Entity.entity(ordenventa, 
                MediaType.APPLICATION_JSON));
        System.out.println("Respuesta: "+response.getStatus());
        return response;
    }
    
    public static Response concluirPedido(Ordenventa ordenventa){
        System.out.println("Solicitando el pedido...");
        clientHttp = ClientBuilder.newClient();
        webTarget = clientHttp.target(URL_BASE).path("/pedidos/solicitar");
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.put(Entity.entity(ordenventa, MediaType.APPLICATION_JSON));
        System.out.println("Respuesta: "+response.getStatus());
        return response;
    }
    
}
