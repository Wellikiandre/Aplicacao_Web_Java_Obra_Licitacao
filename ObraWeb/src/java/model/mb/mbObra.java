/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mb;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Licitacoes;
import model.Obra;
import model.Resumolicitacao;
import model.Usuario;
import model.dao.imp.LicitacaoDao;
import model.dao.imp.ObraDao;
import model.dao.imp.ResumoLicitacaoDao;

/**
 *
 * @author Wellikiandre
 */
@ManagedBean(name = "mbObra")
@ViewScoped
public final class mbObra {

    private List<Obra> obras;
    private List<Resumolicitacao> gastos;
    private Obra obraCad;
    private Obra chLicitacao;
    private Obra listLicitacoes;
    private tipoPage page;
    private Licitacoes licitacao;
    private Resumolicitacao listResumo;
    private Usuario u;
    private int aberto;
    private int andamento;
    private int finalizado;
    private int tmeses;
    private int imeses;
    private Double gastosTotais;

    public mbObra() {

        obras = new ObraDao().findAll();
        obraCad = new Obra();
        obraCad.setIdUsuario(new Usuario());
        licitacao = new Licitacoes();
        u = new Usuario();
        u.setIdUsuario(-1);
        page = page.listar;
        graficoStatus();
        graficoStatus2();
    }

    public String saveObra() {
        new ObraDao().salvar(obraCad);
        return "index";
    }

    public String chamada(Obra obra) {
        chLicitacao = new Obra();
        chLicitacao = obra;
        chLicitacao.getIdobra();
        // boolean podeAbrirLicitacao = new LicitacaoDao().findLicitacaoUser(u, obra);
        page = page.adicionar1;
        return "";
    }

    public String chamada2(Obra obra) {
        chLicitacao = new Obra();
        chLicitacao = obra;
        chLicitacao.getIdobra();
        page = page.licitacao;
        return "";
    }

    public String auditar(Obra obra) {

        licitacao = new Licitacoes();
        licitacao = new LicitacaoDao().findLic(obra.getIdobra());
        page = page.auditar;
        return "";
    }

    public String chamada3(Licitacoes licita) {
        chLicitacao.setStatus("Em andamento");
        chLicitacao = new ObraDao().update(chLicitacao);
        licita.setStatus("Em andamento");
        licita = new LicitacaoDao().update(licita);

        for (Resumolicitacao listRes : licita.getResumolicitacaoList()) {
            listRes.setStatus("Em andamento");
            listRes = new ResumoLicitacaoDao().update(listRes);

        }

        return "index";
    }

    public double valor(List<Resumolicitacao> valor) {
        double x = 0;
        for (Resumolicitacao valor1 : valor) {
            x = valor1.getValor() + x;
        }
        return x;
    }

    public String avancar() {
        licitacao = new LicitacaoDao().salvar(licitacao);
        tmeses = licitacao.getQuantidadeMeses();
        imeses = 1;
        listResumo = new Resumolicitacao();
        listResumo.setIdLicitacao(licitacao);
        listResumo.setMes(imeses);
        page = page.adicionar2;
        return "";
    }

    public void graficoStatus2() {
        gastosTotais = 0.0;
        gastos = new ResumoLicitacaoDao().findAll();
        for (Resumolicitacao rl : gastos) {
            try {
                if (rl.getStatus().equals("Finalizado")) {
                    gastosTotais = rl.getValor() + gastosTotais;
                }

            } catch (Exception e) {
            }

        }

    }

    public void graficoStatus() {
        obras = new ObraDao().findAll();
        aberto = 0;
        finalizado = 0;
        andamento = 0;
        for (Obra obra : obras) {
            if (obra.getStatus().equals("Em aberto")) {
                aberto = aberto + 1;
            } else if (obra.getStatus().equals("Em andamento")) {
                andamento = andamento + 1;
            } else {
                finalizado = finalizado + 1;
            }
        }
    }

    public String validar(Resumolicitacao res) {
        licitacao = new LicitacaoDao().findLic(licitacao.getIdObra().getIdobra());
        res.setStatus("Finalizado");
        new ResumoLicitacaoDao().update(res);
        return "";
    }

    public String finalizarTudo(Resumolicitacao res) {

        new ObraDao().find1(res.getIdLicitacao().getIdObra().getIdobra());

        Licitacoes l = new Licitacoes();
        l = res.getIdLicitacao();
        l.setStatus("Finalizado");
        new LicitacaoDao().update(l);

        return "index";
    }

    public String saveAvancar() {
        // cadastrar
        new ResumoLicitacaoDao().salvar(listResumo);
        imeses++;
        if (imeses <= tmeses) {
            listResumo = new Resumolicitacao();
            listResumo.setIdLicitacao(licitacao);
            listResumo.setMes(imeses);
            return "";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("info", "Licitação Cadastrada com Sucesso"));
        return "index";
    }

    public Obra getObraCad() {
        return obraCad;
    }

    public void setObraCad(Obra obraCad) {
        this.obraCad = obraCad;
    }

    public tipoPage getPage() {
        return page;
    }

    public void setPage(tipoPage page) {
        this.page = page;
    }

    public List<Obra> getObras() {
        return obras;
    }

    public void setObras(List<Obra> obras) {
        this.obras = obras;
    }

    public Obra getChLicitacao() {
        return chLicitacao;
    }

    public void setChLicitacao(Obra chLicitacao) {
        this.chLicitacao = chLicitacao;
    }

    public Licitacoes getLicitacao() {
        return licitacao;
    }

    public void setLicitacao(Licitacoes licitacao) {
        this.licitacao = licitacao;
    }

    public int getTmeses() {
        return tmeses;
    }

    public void setTmeses(int tmeses) {
        this.tmeses = tmeses;
    }

    public int getImeses() {
        return imeses;
    }

    public void setImeses(int imeses) {
        this.imeses = imeses;
    }

    public Resumolicitacao getListResumo() {
        return listResumo;
    }

    public void setListResumo(Resumolicitacao listResumo) {
        this.listResumo = listResumo;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public int getAberto() {
        return aberto;
    }

    public void setAberto(int aberto) {
        this.aberto = aberto;
    }

    public int getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }

    public Obra getListLicitacoes() {
        return listLicitacoes;
    }

    public void setListLicitacoes(Obra listLicitacoes) {
        this.listLicitacoes = listLicitacoes;
    }

    public int getAndamento() {
        return andamento;
    }

    public void setAndamento(int andamento) {
        this.andamento = andamento;
    }

    public List<Resumolicitacao> getGastos() {
        return gastos;
    }

    public void setGastos(List<Resumolicitacao> gastos) {
        this.gastos = gastos;
    }

    public Double getGastosTotais() {
        return gastosTotais;
    }

    public void setGastosTotais(Double gastosTotais) {
        this.gastosTotais = gastosTotais;
    }

}
