/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mb;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Usuario;
import model.dao.imp.UsuarioDao;

/**
 *
 * @author Wellikiandre
 */
@ManagedBean (name = "mbLogin")
@SessionScoped
public class mbLogin {

    private String CpfCnpj, senha;
    private Usuario usuarioLog;
    
    public mbLogin() {
        System.out.println("Objeto Login");
    }
        public void isLogado() {
        if (usuarioLog == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            try {
                context.getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
            }

        }
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.getExternalContext().invalidateSession();

        return "index";
    }

    public String validaLogin() {
        usuarioLog = new UsuarioDao().
                verifyLogin(CpfCnpj, senha);
        if (usuarioLog == null) {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Erro", "Erro ao Logar: "));

            usuarioLog = new Usuario();
            CpfCnpj = senha = "";

            return null;
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Info", "Bem Vindo!!"));
            return "index";
        }
    }

    public String getCpfCnpj() {
        return CpfCnpj;
    }

    public void setCpfCnpj(String CpfCnpj) {
        this.CpfCnpj = CpfCnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(Usuario usuarioLog) {
        this.usuarioLog = usuarioLog;
    }
    
}
