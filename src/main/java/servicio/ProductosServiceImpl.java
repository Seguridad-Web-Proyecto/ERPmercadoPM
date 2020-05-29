/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import datos.ProductosDao;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import domain.Producto1;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author Dann
 */

@Stateless
@WebService (endpointInterface = "servicio.ProductosServiceWS")
public class ProductosServiceImpl implements ProductosServiceRemote, ProductosService, ProductosServiceWS
{
    @Inject
    private ProductosDao productosDao;
    
    @Resource
    private SessionContext contexto;

    @Override
    public List<Producto1> listarProductos() {
        return productosDao.findAllProductos();
    }

    @Override
    public Producto1 encontrarProductoPorId(Producto1 productos) {
        return productosDao.findProductoById(productos);
    }

    @Override
    public void registrarProducto(Producto1 productos) {
        productosDao.insertProducto(productos);
    }

    @Override
    public void modificarProducto(Producto1 productos) {
        try{
            productosDao.updateProducto(productos);
        }catch(Throwable t){
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarProducto(Producto1 productos) {
        productosDao.deleteProducto(productos);
    }

}
