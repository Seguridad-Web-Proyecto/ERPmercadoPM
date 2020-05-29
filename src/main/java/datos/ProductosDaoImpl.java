/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Producto1;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dann
 */
@Stateless
public class ProductosDaoImpl implements ProductosDao
{

    @PersistenceContext(unitName = "com.mycompany_ERPmercado_war_1.0-SNAPSHOTPU")
    EntityManager em;

    @Override
    public List<Producto1> findAllProductos()
    {
        return em.createNamedQuery("Producto.findAll").getResultList();
    }

    @Override
    public Producto1 findProductoById(Producto1 productos)
    {
        return em.find(Producto1.class, productos.getProductoid());
    }

    @Override
    public void insertProducto(Producto1 productos)
    {
        em.persist(productos);
    }

    @Override
    public void updateProducto(Producto1 productos)
    {
        em.merge(productos);
    }

    @Override
    public void deleteProducto(Producto1 productos)
    {
        em.remove(em.merge(productos));
    }
    
}
