/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

/**
 *
 * @author Dann
 */
import domain.Producto1;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ProductosServiceRemote
{
    public List<Producto1> listarProductos();
    
    public Producto1 encontrarProductoPorId(Producto1 productos);
        
    public void registrarProducto(Producto1 productos);
    
    public void modificarProducto(Producto1 productos);
    
    public void eliminarProducto(Producto1 productos);

}
