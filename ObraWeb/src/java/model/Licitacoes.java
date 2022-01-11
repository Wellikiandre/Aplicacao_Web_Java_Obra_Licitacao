/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
    @NamedQuery(name = "Licitacoes.findAll", query = "SELECT l FROM Licitacoes l"),
    @NamedQuery(name = "Licitacoes.findByIdlicitacoes", query = "SELECT l FROM Licitacoes l WHERE l.idlicitacoes = :idlicitacoes"),
    @NamedQuery(name = "Licitacoes.findByQuantidadeMeses", query = "SELECT l FROM Licitacoes l WHERE l.quantidadeMeses = :quantidadeMeses"),
    @NamedQuery(name = "Licitacoes.findByDescricao", query = "SELECT l FROM Licitacoes l WHERE l.descricao = :descricao"),
    @NamedQuery(name = "Licitacoes.findByStatus", query = "SELECT l FROM Licitacoes l WHERE l.status = :status")})
public class Licitacoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idlicitacoes;
    private Integer quantidadeMeses;
    @Column(length = 45)
    private String descricao;
    @Column(length = 45)
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLicitacao")
    private List<Resumolicitacao> resumolicitacaoList;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "idObra", referencedColumnName = "idobra", nullable = false)
    @ManyToOne(optional = false)
    private Obra idObra;

    public Licitacoes() {
    }

    public Licitacoes(Integer idlicitacoes) {
        this.idlicitacoes = idlicitacoes;
    }

    public Integer getIdlicitacoes() {
        return idlicitacoes;
    }

    public void setIdlicitacoes(Integer idlicitacoes) {
        this.idlicitacoes = idlicitacoes;
    }

    public Integer getQuantidadeMeses() {
        return quantidadeMeses;
    }

    public void setQuantidadeMeses(Integer quantidadeMeses) {
        this.quantidadeMeses = quantidadeMeses;
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

    @XmlTransient
    public List<Resumolicitacao> getResumolicitacaoList() {
        return resumolicitacaoList;
    }

    public void setResumolicitacaoList(List<Resumolicitacao> resumolicitacaoList) {
        this.resumolicitacaoList = resumolicitacaoList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Obra getIdObra() {
        return idObra;
    }

    public void setIdObra(Obra idObra) {
        this.idObra = idObra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlicitacoes != null ? idlicitacoes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licitacoes)) {
            return false;
        }
        Licitacoes other = (Licitacoes) object;
        if ((this.idlicitacoes == null && other.idlicitacoes != null) || (this.idlicitacoes != null && !this.idlicitacoes.equals(other.idlicitacoes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.dao.Licitacoes[ idlicitacoes=" + idlicitacoes + " ]";
    }
    
}
