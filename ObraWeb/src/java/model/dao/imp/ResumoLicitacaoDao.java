/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.imp;

import java.util.List;
import javax.persistence.Query;
import model.Resumolicitacao;
import model.dao.DaoGenerics;

/**
 *
 * @author Wellikiandre
 */
public class ResumoLicitacaoDao extends DaoGenerics{
    public Resumolicitacao salvar(Resumolicitacao rl) {
        con.getTransaction().begin();
        con.persist(rl);
        con.getTransaction().commit();
        return rl;
    }
    
    public List<Resumolicitacao> findAll() {
        Query q = con.createNamedQuery("Resumolicitacao.findAll");
        return q.getResultList();
    }


    public Resumolicitacao update(Resumolicitacao listRes) {
        con.getTransaction().begin();
        con.merge(listRes);
        con.getTransaction().commit();
        return listRes;    
    }
}
