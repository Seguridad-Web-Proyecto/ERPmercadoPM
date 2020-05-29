/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dann
 */
@XmlRootElement(name ="Producto")
public class ProductoPojo
{
    
    private Long productoid;
   
    private String nombre;
   
    private String descripcion;
    
    private String unidadMedida;
   
    private int precioUnitario;
    
    private long categoriaid;

    /**
     * @return the productoid
     */
    public Long getProductoid()
    {
        return productoid;
    }

    /**
     * @param productoid the productoid to set
     */
    public void setProductoid(Long productoid)
    {
        this.productoid = productoid;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * @return the unidadMedida
     */
    public String getUnidadMedida()
    {
        return unidadMedida;
    }

    /**
     * @param unidadMedida the unidadMedida to set
     */
    public void setUnidadMedida(String unidadMedida)
    {
        this.unidadMedida = unidadMedida;
    }

    /**
     * @return the precioUnitario
     */
    public int getPrecioUnitario()
    {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(int precioUnitario)
    {
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the categoriaid
     */
    public long getCategoriaid()
    {
        return categoriaid;
    }

    /**
     * @param categoriaid the categoriaid to set
     */
    public void setCategoriaid(long categoriaid)
    {
        this.categoriaid = categoriaid;
    }

    @Override
    public String toString()
    {
        return "ProductoPojo{" + "productoid=" + productoid + ", nombre=" + nombre + ", descripcion=" + descripcion + ", unidadMedida=" + unidadMedida + ", precioUnitario=" + precioUnitario + ", categoriaid=" + categoriaid + '}';
    }
    
    
}
