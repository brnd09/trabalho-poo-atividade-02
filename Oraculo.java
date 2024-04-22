package com.mycompany.atividade02;

import java.util.Random;

public class Oraculo {

    Guerreiro warrior;
    String nome;
    boolean loadLevel01, loadLevel02, decidirVidaExtra;

    public void warrior (Guerreiro warrior) {
        this.warrior = warrior;
    }

    public void definirNome(String nome) {
        this.nome = nome;
        InOut.leString(nome);
    }

    public String prologoIntroducao(int vidas) {
        return "Eu sou " + nome + ". Guerreiro, você começa com " + vidas + " vidas.";
    }

    public String prologoVencedor() {
        return "Parabéns, " + warrior.getNome() + "! Você é o vencedor!";
    }

    public String prologoPerdedor() {
        return "Desculpe, " + warrior.getNome() + ". Você perdeu.";
    }

    public boolean loadLevel01(int palpite) {
        Random rand = new Random();
        int segredo = rand.nextInt(100) + 1;
        return segredo == palpite;
    }

    public boolean loadLevel02(boolean opcaoPar) {
        Random rand = new Random();
        int oraculo = rand.nextInt(6);
        int guerreiro = rand.nextInt(6);
        int soma = oraculo + guerreiro;

        return (soma % 2 == 0) == opcaoPar;
    }

    public boolean decidirVidaExtra(String pedido) {
        String[] palavras = pedido.split(" ");
        return palavras.length > 5;
    }

    public int sortearVidas() {
        Random rand = new Random();
        return rand.nextInt(4) + 9;
    }

}
