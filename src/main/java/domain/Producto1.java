/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dann
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByProductoid", query = "SELECT p FROM Producto p WHERE p.productoid = :productoid"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByUnidadMedida", query = "SELECT p FROM Producto p WHERE p.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "Producto.findByPrecioUnitario", query = "SELECT p FROM Producto p WHERE p.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "Producto.findByCategoriaid", query = "SELECT p FROM Producto p WHERE p.categoriaid = :categoriaid")
})
public class Producto1 implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productoid")
    private Long productoid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unitario")
    private int precioUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoriaid")
    private long categoriaid;

    public Producto1()
    {
    }

    public Producto1(Long productoid)
    {
        this.productoid = productoid;
    }

    public Producto1(Long productoid, String nombre, String descripcion, String unidadMedida, int precioUnitario, long categoriaid)
    {
        this.productoid = productoid;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.precioUnitario = precioUnitario;
        this.categoriaid = categoriaid;
    }

    public Long getProductoid()
    {
        return productoid;
    }

    public void setProductoid(Long productoid)
    {
        this.productoid = productoid;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getUnidadMedida()
    {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida)
    {
        this.unidadMedida = unidadMedida;
    }

    public int getPrecioUnitario()
    {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario)
    {
        this.precioUnitario = precioUnitario;
    }

    public long getCategoriaid()
    {
        return categoriaid;
    }

    public void setCategoriaid(long categoriaid)
    {
        this.categoriaid = categoriaid;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (productoid != null ? productoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto1))
        {
            return false;
        }
        Producto1 other = (Producto1) object;
        if ((this.productoid == null && other.productoid != null) || (this.productoid != null && !this.productoid.equals(other.productoid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "domain.Producto[ productoid=" + productoid + " ]";
    }
    
}
