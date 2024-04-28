package org.example;

import java.util.Random;

public class Oraculo {
    private String nome_oraculo;  // Nome do Oráculo
    private final Random random = new Random();  // Para sorteios

    public Oraculo(String nome) {
        this.nome_oraculo = nome;  // Define o nome do Oráculo ao instanciar
    }

    public void definirNome(String nome) {
        this.nome_oraculo = nome;  // Permite redefinir o nome do Oráculo
    }

    public int sortearVidas() {
        return 9 + random.nextInt(4);  // Retorna um número entre 9 e 12
    }

    public String prologoIntroducao(Guerreiro guerreiro) {
        return "Oráculo " + nome_oraculo + ":\n" +
                "\nGuerreiro " + guerreiro.getNome_guerreiro() + ", você terá " +
                guerreiro.getQtdVidas() + " vidas para enfrentar os desafios.\n" +
                "Prepare-se para a aventura!";
    }

    public boolean loadLevel1(Guerreiro guerreiro) {
        int numeroSorteado = 1 + random.nextInt(100);  // Sorteia um número entre 1 e 100
        int palpiteGuerreiro;
        boolean acertou = false;

        do {
            palpiteGuerreiro = InOut.leInt("Guerreiro " + guerreiro.getNome_guerreiro() + ", faça um palpite entre 1 e 100: ");

            if (palpiteGuerreiro < numeroSorteado) {
                InOut.MsgDeAviso("Dica", "O segredo é MAIOR que o seu palpite.");
            } else if (palpiteGuerreiro > numeroSorteado) {
                InOut.MsgDeAviso("Dica", "O segredo é MENOR que o seu palpite.");
            } else {
                InOut.MsgDeInformacao("Parabéns", "Parabéns, Guerreiro " + guerreiro.getNome_guerreiro() + "! Você acertou!");
                acertou = true;
            }

            guerreiro.perderVida();  // Cada erro perde uma vida
            InOut.MsgDeAviso("Vidas", "Você perdeu uma vida! Restam " + guerreiro.getQtdVidas() + " vidas.");

        } while (!acertou && guerreiro.getQtdVidas() > 0);  // Continua até acertar ou acabar as vidas

        return acertou;  // Retorna se o Guerreiro ganhou ou perdeu
    }

    public boolean loadLevel2(Guerreiro guerreiro) {
        String escolha = InOut.leString("Guerreiro " + guerreiro.getNome_guerreiro() + ", escolha PAR ou ÍMPAR: ").toUpperCase();

        int numeroGuerreiro = random.nextInt(6);  // Número entre 0 e 5
        int numeroOraculo = random.nextInt(6);  // Número entre 0 e 5
        int soma = numeroGuerreiro + numeroOraculo;  // Soma dos números

        boolean ehPar = (soma % 2 == 0);  // Verifica se é par ou ímpar

        boolean guerreiroGanhou = (escolha.equals("PAR") && ehPar) || (escolha.equals("ÍMPAR") && !ehPar);  // Verifica se o Guerreiro ganhou

        if (guerreiroGanhou) {
            InOut.MsgDeInformacao("Resultado", "Você ganhou! A soma foi " + soma + ", que é " + (ehPar ? "PAR" : "ÍMPAR"));
        } else {
            InOut.MsgDeInformacao("Resultado", "Você perdeu! A soma foi " + soma + ", que é " + (ehPar ? "PAR" : "ÍMPAR"));
        }

        return guerreiroGanhou;  // Retorna se o Guerreiro ganhou ou perdeu
    }

    public String prologoVencedor() {
        return "Parabéns, Guerreiro! Você venceu o jogo!";
    }

    public String prologoPerdedor() {
        return "Infelizmente, Guerreiro, você perdeu o jogo. Tente novamente!";
    }

    public boolean decidirVidaExtra(String pedido) {
        String[] palavras = pedido.split("\\s+");  // Dividido por espaços

        return palavras.length > 5;  // Concede vida extra se o pedido tiver mais que cinco palavras
    }
}
