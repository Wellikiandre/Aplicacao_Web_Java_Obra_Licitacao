/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Usuario;
import model.dao.imp.UsuarioDao;

/**
 *
 * @author Wellikiandre
 */
@ManagedBean(name = "mbUsuarioCad")
@ViewScoped
public class mbUsuarioCad {
    
    private Usuario usuario;
    private StatusTelaUsuario enumUser; 
 
    public mbUsuarioCad() {
        
    usuario = new Usuario();
    enumUser = enumUser.cadastrar;
    }
    
    public String save()
    {
    FacesContext context = FacesContext.getCurrentInstance();
    new UsuarioDao().salvar(usuario);  
    
     if (usuario == null) {
            context.addMessage(null,
                    new FacesMessage("Erro", "Erro ao Salvar: "));
            return "";
        } else {
            context.addMessage(null,
                    new FacesMessage("Salvo", "Salvo com sucesso: "));
            return "index";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public StatusTelaUsuario getEnumUser() {
        return enumUser;
    }

    public void setEnumUser(StatusTelaUsuario enumUser) {
        this.enumUser = enumUser;
    }
    
    
    
    
    
    
    
    
}
