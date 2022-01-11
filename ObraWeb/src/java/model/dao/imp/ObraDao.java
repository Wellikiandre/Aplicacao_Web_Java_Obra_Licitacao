/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.imp;

import java.util.List;
import javax.persistence.Query;
import model.Obra;
import model.dao.DaoGenerics;

/**
 *
 * @author Wellikiandre
 */
public class ObraDao extends DaoGenerics{

   
     public Obra salvar(Obra obra) {
        con.getTransaction().begin();
        con.persist(obra);
        con.getTransaction().commit();
        return obra;
    }

    public List<Obra> findAll() {
        Query q = con.createNamedQuery("Obra.findAll");
        return q.getResultList();
    }

    public Obra update(Obra obra) {
        con.getTransaction().begin();
        con.merge(obra) ;
        con.getTransaction().commit();
        return obra;    
    
    }
    
     public void find1(int idobra) {
     Query q = con.createQuery("SELECT o FROM Obra o WHERE o.idobra = :id");
     q.setParameter("id", idobra);
     Obra a = new Obra();
     a = (Obra) q.getSingleResult();
     a.setStatus("Finalizado");
     update(a);
    }

    
    
}
