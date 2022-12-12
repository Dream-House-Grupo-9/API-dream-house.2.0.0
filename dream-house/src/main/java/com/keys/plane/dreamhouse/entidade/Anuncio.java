package com.keys.plane.dreamhouse.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String telefoneLocatario;
    private String cidade;
    private String bairro;
    private String logradouro;
    private int numero;
    private Double valDiario;

    private String image;
    private String descricao;
    private LocalDate dtPublicacao;
    private LocalDate inicioDisponibilidade;
    private LocalDate finalDisponibilidade;

//    @JsonIgnore
//    @Column(length = 50 * 1024 * 1024) // 50 Mb
//    private byte[] foto;

    @ManyToOne
    @NotNull
    private Cliente cliente;

    @OneToOne()
    private DetalhesAnuncio detalhe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTelefoneLocatario() {
        return telefoneLocatario;
    }

    public void setTelefoneLocatario(String telefoneLocatario) {
        this.telefoneLocatario = telefoneLocatario;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Double getValDiario() {
        return valDiario;
    }

    public void setValDiario(Double valDiario) {
        this.valDiario = valDiario;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(LocalDate dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public LocalDate getInicioDisponibilidade() {
        return inicioDisponibilidade;
    }

    public void setInicioDisponibilidade(LocalDate inicioDisponibilidade) {
        this.inicioDisponibilidade = inicioDisponibilidade;
    }

    public LocalDate getFinalDisponibilidade() {
        return finalDisponibilidade;
    }

    public void setFinalDisponibilidade(LocalDate finalDisponibilidade) {
        this.finalDisponibilidade = finalDisponibilidade;
    }

//    public byte[] getFoto() {
//        return foto;
//    }
//
//    public void setFoto(byte[] foto) {
//        this.foto = foto;
//    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetalhesAnuncio getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(DetalhesAnuncio detalhe) {
        this.detalhe = detalhe;
    }
}
