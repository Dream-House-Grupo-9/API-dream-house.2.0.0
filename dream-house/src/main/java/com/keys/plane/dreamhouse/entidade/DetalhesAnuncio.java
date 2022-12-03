package com.keys.plane.dreamhouse.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class DetalhesAnuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalhesAnuncio;

    @NotNull
    private boolean ativoDiaria;

    @NotNull
    private boolean ativoSemanal;

    @NotNull
    private boolean ativoMensal;

    @NotNull
    private double valorDiaria;


    private double valorSemanal;


    private double valorMes;

    @Positive
    private int qtdDormitorios;

    @Positive
    private int qtdToaletes;

    private boolean garagem;

    private boolean areaDeTrabalho;

    private boolean mobiliada;

    @NotBlank
    private String categoria;

    private Integer qtdCurtidas;

    public Integer getIdDetalhesAnuncio() {
        return idDetalhesAnuncio;
    }

    public void setIdDetalhesAnuncio(Integer idDetalhesAnuncio) {
        this.idDetalhesAnuncio = idDetalhesAnuncio;
    }

    public boolean isAtivoDiaria() {
        return ativoDiaria;
    }

    public void setAtivoDiaria(boolean ativoDiaria) {
        this.ativoDiaria = ativoDiaria;
    }

    public boolean isAtivoSemanal() {
        return ativoSemanal;
    }

    public void setAtivoSemanal(boolean ativoSemanal) {
        this.ativoSemanal = ativoSemanal;
    }

    public boolean isAtivoMensal() {
        return ativoMensal;
    }

    public void setAtivoMensal(boolean ativoMensal) {
        this.ativoMensal = ativoMensal;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorSemanal() {
        return valorSemanal;
    }

    public void setValorSemanal(double valorSemanal) {
        this.valorSemanal = valorSemanal;
    }

    public double getValorMes() {
        return valorMes;
    }

    public void setValorMes(double valorMes) {
        this.valorMes = valorMes;
    }

    public int getQtdDormitorios() {
        return qtdDormitorios;
    }

    public void setQtdDormitorios(int qtdDormitorios) {
        this.qtdDormitorios = qtdDormitorios;
    }

    public int getQtdToaletes() {
        return qtdToaletes;
    }

    public void setQtdToaletes(int qtdToaletes) {
        this.qtdToaletes = qtdToaletes;
    }

    public boolean isGaragem() {
        return garagem;
    }

    public void setGaragem(boolean garagem) {
        this.garagem = garagem;
    }

    public boolean isAreaDeTrabalho() {
        return areaDeTrabalho;
    }

    public void setAreaDeTrabalho(boolean areaDeTrabalho) {
        this.areaDeTrabalho = areaDeTrabalho;
    }

    public boolean isMobiliada() {
        return mobiliada;
    }

    public void setMobiliada(boolean mobiliada) {
        this.mobiliada = mobiliada;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getQtdCurtidas() {
        return qtdCurtidas;
    }

    public void setQtdCurtidas(Integer qtdCurtidas) {
        this.qtdCurtidas = qtdCurtidas;
    }
}
