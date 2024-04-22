package com.mycompany.atividade02;

public class Guerreiro {

    String nome, vidaExtra;
    int qtdVidas;

    public String vidaExtra(String pedido) {
        return "Pedido de Misericórdia: " + pedido;
    }

    String getNome() {
        return InOut.leString(nome);
    }

}
