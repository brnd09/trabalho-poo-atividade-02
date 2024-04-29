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
      int numeroSorteado = 1 + random.nextInt(100); // Número entre 1 e 100
      boolean acertou = false;

      while (!acertou && guerreiro.getQtdVidas() > 0) {
          int palpite = InOut.leInt("Guerreiro " + guerreiro.getNome_guerreiro() + ", faça um palpite entre 1 e 100: ");

          if (palpite < numeroSorteado) {
              InOut.MsgDeAviso("Dica", "O segredo é maior que o seu palpite.");
              guerreiro.perderVida(); // Perde uma vida por erro
          } else if (palpite > numeroSorteado) {
              InOut.MsgDeAviso("Dica", "O segredo é menor que o seu palpite.");
              guerreiro.perderVida(); // Perde uma vida por erro
          } else {
              InOut.MsgDeInformacao("Parabéns", "Você acertou!");
              acertou = true; // O Guerreiro acertou, então não perde vida
          }

          if (!acertou) { // Apenas se ele ainda não acertou
              InOut.MsgDeAviso("Vidas", "Você perdeu uma vida! Restam " + guerreiro.getQtdVidas() + " vidas.");
          }
      }

      return acertou;
  }

  public boolean loadLevel2(Guerreiro guerreiro) {
      String escolha = InOut.leString("Guerreiro " + guerreiro.getNome_guerreiro() + ", escolha PAR ou ÍMPAR: ").toUpperCase();

      int numeroGuerreiro = random.nextInt(6); // Número entre 0 e 5
      int numeroOraculo = random.nextInt(6); // Número entre 0 e 5
      int soma = numeroGuerreiro + numeroOraculo;

      boolean ehPar = (soma % 2 == 0);
      boolean guerreiroGanhou = (escolha.equals("PAR") && ehPar) || (escolha.equals("ÍMPAR") && !ehPar); // Use '||' para 'ou'

      if (guerreiroGanhou) {
          InOut.MsgDeInformacao("Resultado", "Você ganhou! A soma foi " + soma + ", que é " + (ehPar ? "PAR" : "ÍMPAR"));
      } else {
          InOut.MsgDeInformacao("Resultado", "Você perdeu! A soma foi " + soma + ", que é " + (ehPar ? "PAR" : "ÍMPAR"));
      }

      return guerreiroGanhou;
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
