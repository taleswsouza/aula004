/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aula.banco;

/**
 *
 * @author Tale Wallace <tales.wallace at gmail.com>
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente(1, "Obama", 100); // cria um novo objeto da classe conta corrente
//        c1.setNumero(1);
//        c1.setNome("Obama");
//        c1.setSaldo(100);
        c1.depositar(10);

        System.out.println("Conta c1: " + c1.getNumero() + ", " + c1.getNome() + ", " + c1.getSaldo());

        ContaCorrente c2 = new ContaCorrente(5000, "Diana", 543); // cria um novo objeto da classe conta corrente
//        c2.setNumero(5000);
//        c2.setNome("Diana");
//        c2.setSaldo(543);
        c2.sacar(3);
        c2.sacar(40);
//        c2.setSaldo(543);

        System.out.println("Conta c2: " + c2.getNumero() + ", " + c2.getNome() + ", " + c2.getSaldo());

    }

}
