/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restapplication.service;

import entidades.Ganancia;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restapplication.Common;
import restapplication.api_consumer.APIConsumer;
import restapplication.pojos.ProductoPOJO;

/**
 *
 * @author jcami
 */
@Stateless
@Path("productos")
public class ProductoFacadeREST extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "com.mycompany_ERPmercado_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ProductoFacadeREST() {
        super(Producto.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producto find(@PathParam("id") Long id) {
        Producto producto = Common.convertirProductoPojoAProducto(APIConsumer.obtenerProductoXId(id));
        Ganancia ganancia = new Ganancia();
        ganancia.setPorcentaje((short)10);
        producto.setGanancia(ganancia);
        Producto p = Common.aplicarGananciaAlProducto(producto);
        p.getCategoriaid().setNombre(null);
        return p;
    }
    
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> findAll() {
        List<ProductoPOJO> productosAPI = APIConsumer.productos("");
        List<Producto> returnList = new ArrayList<>();
        for(ProductoPOJO productoPOJO: productosAPI){
            Producto producto = Common.convertirProductoPojoAProducto(productoPOJO);
            Ganancia ganancia = new Ganancia();
            ganancia.setPorcentaje((short)10);
            producto.setGanancia(ganancia);
            Producto p = Common.aplicarGananciaAlProducto(producto);
            p.getCategoriaid().setNombre(null);
            returnList.add(p);
        }
        return returnList;
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        List<ProductoPOJO> productosAPI = APIConsumer.productos("/"+from.toString()+"/"+to.toString());
        List<Producto> returnList = new ArrayList<>();
        for(ProductoPOJO productoPOJO: productosAPI){
            Producto producto = Common.convertirProductoPojoAProducto(productoPOJO);
            Producto p = Common.aplicarGananciaAlProducto(producto);
            returnList.add(p);
        }
        return returnList;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return APIConsumer.productosCOUNT();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}