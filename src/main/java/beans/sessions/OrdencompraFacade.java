/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sessions;

import entidades.Ordencompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Saul
 */
@Stateless
public class OrdencompraFacade extends AbstractFacade<Ordencompra> {

    @PersistenceContext(unitName = "com.mycompany_ERPmercado_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdencompraFacade() {
        super(Ordencompra.class);
    }
    
}
