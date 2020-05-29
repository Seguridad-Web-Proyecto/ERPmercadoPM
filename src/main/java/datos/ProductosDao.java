/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import domain.Producto1;

/**
 *
 * @author Dann
 */

public interface ProductosDao
{

    public List<Producto1> findAllProductos();

    public Producto1 findProductoById(Producto1 productos);

    public void insertProducto(Producto1 productos);

    public void updateProducto(Producto1 productos);

    public void deleteProducto(Producto1 productos);

}
