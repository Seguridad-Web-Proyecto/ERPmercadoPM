/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import domain.Producto1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dann
 */
@Local
public interface ProductosService
{

    public List<Producto1> listarProductos();

    public Producto1 encontrarProductoPorId(Producto1 productos);

    public void registrarProducto(Producto1 productos);

    public void modificarProducto(Producto1 productos);

    public void eliminarProducto(Producto1 productos);

}
