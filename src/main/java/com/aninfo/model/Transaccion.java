package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTransaccion;
    @ManyToOne
    private Account account;

    private Double saldoAnterior;
    private Double saldoPosterior;

    public Transaccion(Account account,Long idTransaccion,Double saldoAnterior,Double saldoPosterior){
        this.account=account;
        this.idTransaccion=idTransaccion;
        this.saldoAnterior=saldoAnterior;
        this.saldoPosterior=saldoPosterior;
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
