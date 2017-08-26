package com.aula.banco;

/**
 *
 * @author Tale Wallace <tales.wallace at gmail.com>
 */
public class ContaCorrente {
    private int numero;
    private String nome;
    private int saldo;
    
    public void depositar(int valor) {
        saldo = saldo + valor;
    }    
    public void sacar(int valor) {
        saldo = saldo - valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome.toUpperCase();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContaCorrente(int numero, String nome, int saldo) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }
}
