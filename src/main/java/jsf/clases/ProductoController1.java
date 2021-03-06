package jsf.clases;


import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import restapplication.api_consumer.APIConsumerMercado;
import restapplication.pojos.ProductoPOJO;

@Named("productoController1")
@SessionScoped
public class ProductoController1 implements Serializable
{

    private List<ProductoPOJO> items = null;
    private ProductoPOJO selected;
    private List<ProductoPOJO> selectedWs;


    public ProductoController1()
    {
    }

    public ProductoPOJO getSelected()
    {
        return selected;
    }

    public void setSelected(ProductoPOJO selected)
    {
        this.selected = selected;
    }

    public List<ProductoPOJO> getSelectedWs()
    {
        return selectedWs;
    }

    public void setSelectedWs(List<ProductoPOJO> selectedWs)
    {
        this.selectedWs = selectedWs;
    }

    protected void setEmbeddableKeys()
    {
    }

    protected void initializeEmbeddableKey()
    {
    }

    public List<ProductoPOJO> getItemsWs()
    {
        items = APIConsumerMercado.productos("");
        return items;
    }



}