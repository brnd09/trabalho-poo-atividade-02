package org.example;

public class Guerreiro {
    private String nome_guerreiro;  // Nome do Guerreiro
    private int qtdVidas;  // Quantidade de vidas

    public Guerreiro(String nome) {
        this.nome_guerreiro = nome;  // Define o nome do Guerreiro
        this.qtdVidas = 0;  // Inicializa as vidas
    }

    public void definirNome(String nome) {
        this.nome_guerreiro = nome;  // Permite redefinir o nome
    }

    public void ganharVida() {
        this.qtdVidas++;  // Guerreiro ganha uma vida
    }

    public void perderVida() {
        this.qtdVidas--;  // Guerreiro perde uma vida
    }

    public String getNome_guerreiro() {
        return nome_guerreiro;  // Retorna o nome do Guerreiro
    }

    public int getQtdVidas() {
        return qtdVidas;  // Retorna a quantidade de vidas
    }

    public void setQtdVidas(int qtdVidas) {
        this.qtdVidas = qtdVidas;  // Permite definir a quantidade de vidas
    }

    public String vidaExtra() {
        return InOut.leString("Guerreiro " + nome_guerreiro + ", faça um pedido de misericórdia por uma vida extra: ");
    }
}
