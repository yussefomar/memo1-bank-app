package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTransaccion;
    @ManyToOne
    private Account account;

    private Double saldoAnterior= (double) 0;
    private Double saldoPosterior= (double) 0;
    private String tipo;

    public Transaccion(){
        /*this.account=account;
        this.idTransaccion=idTransaccion;
        this.saldoAnterior=saldoAnterior;
        this.saldoPosterior=saldoPosterior;*/
    }

    public Account getAccount(){
        return this.account;
    }

    public void setAccount(Account account){
        this.account=account;
    }



    public Long getidTransaccion() {
        return idTransaccion;
    }

    public void setidTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public String getTipo(){
        return this.tipo;
    }
    public Double getsaldoAnterior() {
        return saldoAnterior;
    }
    public Double getsaldoPosterior() {
        return saldoPosterior;
    }

    public void setsaldoAnterior(Double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }
    public void setsaldoPosterior(Double saldoPosterior) {
        this.saldoPosterior = saldoPosterior;
    }

}
