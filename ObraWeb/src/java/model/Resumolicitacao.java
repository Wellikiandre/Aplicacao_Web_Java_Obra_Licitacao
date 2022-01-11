/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wellikiandre
 */
@Entity
@Table(catalog = "obrajava", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resumolicitacao.findAll", query = "SELECT r FROM Resumolicitacao r"),
    @NamedQuery(name = "Resumolicitacao.findByIdresumoLicitacao", query = "SELECT r FROM Resumolicitacao r WHERE r.idresumoLicitacao = :idresumoLicitacao"),
    @NamedQuery(name = "Resumolicitacao.findByMes", query = "SELECT r FROM Resumolicitacao r WHERE r.mes = :mes"),
    @NamedQuery(name = "Resumolicitacao.findByValor", query = "SELECT r FROM Resumolicitacao r WHERE r.valor = :valor"),
    @NamedQuery(name = "Resumolicitacao.findByDescricao", query = "SELECT r FROM Resumolicitacao r WHERE r.descricao = :descricao"),
    @NamedQuery(name = "Resumolicitacao.findByUnidade", query = "SELECT r FROM Resumolicitacao r WHERE r.unidade = :unidade"),
    @NamedQuery(name = "Resumolicitacao.findByStatus", query = "SELECT r FROM Resumolicitacao r WHERE r.status = :status")})
public class Resumolicitacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idresumoLicitacao;
    private Integer mes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double valor;
    @Column(length = 45)
    private String descricao;
    @Column(length = 45)
    private String unidade;
    @Column(length = 45)
    private String status;
    @JoinColumn(name = "idLicitacao", referencedColumnName = "idlicitacoes", nullable = false)
    @ManyToOne(optional = false)
    private Licitacoes idLicitacao;

    public Resumolicitacao() {
    }

    public Resumolicitacao(Integer idresumoLicitacao) {
        this.idresumoLicitacao = idresumoLicitacao;
    }

    public Integer getIdresumoLicitacao() {
        return idresumoLicitacao;
    }

    public void setIdresumoLicitacao(Integer idresumoLicitacao) {
        this.idresumoLicitacao = idresumoLicitacao;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Licitacoes getIdLicitacao() {
        return idLicitacao;
    }

    public void setIdLicitacao(Licitacoes idLicitacao) {
        this.idLicitacao = idLicitacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresumoLicitacao != null ? idresumoLicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resumolicitacao)) {
            return false;
        }
        Resumolicitacao other = (Resumolicitacao) object;
        if ((this.idresumoLicitacao == null && other.idresumoLicitacao != null) || (this.idresumoLicitacao != null && !this.idresumoLicitacao.equals(other.idresumoLicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.dao.Resumolicitacao[ idresumoLicitacao=" + idresumoLicitacao + " ]";
    }
    
}
