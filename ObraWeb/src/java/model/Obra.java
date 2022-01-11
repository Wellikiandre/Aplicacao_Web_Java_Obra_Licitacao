/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wellikiandre
 */
@Entity
@Table(catalog = "obrajava", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obra.findAll", query = "SELECT o FROM Obra o"),
    @NamedQuery(name = "Obra.findByIdobra", query = "SELECT o FROM Obra o WHERE o.idobra = :idobra"),
    @NamedQuery(name = "Obra.findByPrazo", query = "SELECT o FROM Obra o WHERE o.prazo = :prazo"),
    @NamedQuery(name = "Obra.findByPrioridade", query = "SELECT o FROM Obra o WHERE o.prioridade = :prioridade"),
    @NamedQuery(name = "Obra.findByValor", query = "SELECT o FROM Obra o WHERE o.valor = :valor"),
    @NamedQuery(name = "Obra.findByDescricao", query = "SELECT o FROM Obra o WHERE o.descricao = :descricao"),
    @NamedQuery(name = "Obra.findByStatus", query = "SELECT o FROM Obra o WHERE o.status = :status"),
    @NamedQuery(name = "Obra.findByTipoObra", query = "SELECT o FROM Obra o WHERE o.tipoObra = :tipoObra")})
public class Obra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idobra;
    @Temporal(TemporalType.DATE)
    private Date prazo;
    @Column(length = 45)
    private String prioridade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double valor;
    @Column(length = 45)
    private String descricao;
    @Column(length = 45)
    private String status;
    @Column(length = 45)
    private String tipoObra;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObra")
    private List<Licitacoes> licitacoesList;

    public Obra() {
    }

    public Obra(Integer idobra) {
        this.idobra = idobra;
    }

    public Integer getIdobra() {
        return idobra;
    }

    public void setIdobra(Integer idobra) {
        this.idobra = idobra;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Licitacoes> getLicitacoesList() {
        return licitacoesList;
    }

    public void setLicitacoesList(List<Licitacoes> licitacoesList) {
        this.licitacoesList = licitacoesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idobra != null ? idobra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obra)) {
            return false;
        }
        Obra other = (Obra) object;
        if ((this.idobra == null && other.idobra != null) || (this.idobra != null && !this.idobra.equals(other.idobra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.dao.Obra[ idobra=" + idobra + " ]";
    }
    
}
