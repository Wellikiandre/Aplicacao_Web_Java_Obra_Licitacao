/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.imp;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Usuario;
import model.dao.DaoGenerics;

/**
 *
 * @author Wellikiandre
 */
public class UsuarioDao extends DaoGenerics{

    public Usuario salvar(Usuario usuario) {
        con.getTransaction().begin();
        con.persist(usuario);
        con.getTransaction().commit();
        return usuario;
    }

    public Usuario verifyLogin(String CpfCnpj, String senha) {
        Query q = con.createNamedQuery("Usuario.CpfCnpjAndSenha");
        q.setParameter("cpfcnpj", CpfCnpj);
        q.setParameter("senha", senha);
        try {
            return (Usuario) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
