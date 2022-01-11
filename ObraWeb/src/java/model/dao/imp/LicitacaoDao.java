/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.imp;

import java.util.List;
import javax.persistence.Query;
import model.Licitacoes;
import model.Obra;
import model.Usuario;
import model.dao.DaoGenerics;

/**
 *
 * @author Wellikiandre
 */
public class LicitacaoDao extends DaoGenerics{
    public Licitacoes salvar(Licitacoes lic) {
        con.getTransaction().begin();
        con.persist(lic);
        con.getTransaction().commit();
        return lic;
    }

    public boolean findLicitacaoUser(Usuario user, Obra obra) {
        
        Query q = con.createQuery("SELECT l FROM Licitacoes l WHERE l.idObra.idobra = :obra and l.idUsuario.idUsuario = user");

        q.setParameter("obra", obra.getIdobra());
        q.setParameter("user", user.getIdUsuario());
        if (q.getResultList() == null)
        {
         return true;
        }
        else
        {
        return false;
        }
       
    
    }

    public Licitacoes update(Licitacoes licita) {
        con.getTransaction().begin();
        con.merge(licita);
        con.getTransaction().commit();
        return licita;    
    }

    public Licitacoes findLic(Integer idobra) {
    
        Query q = con.createQuery("SELECT l FROM Licitacoes l WHERE l.idObra.idobra = :id and l.status = :s");
        q.setParameter("id", idobra );
        q.setParameter("s","Em andamento");
        
        
        return (Licitacoes) q.getSingleResult();
    }
}
