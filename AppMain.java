public class Main {
    public static void main(String[] args) {
        // Entrada dos nomes do Oráculo e do Guerreiro
        String nomeOraculo = InOut.leString("Digite o nome do Oráculo: ");
        String nomeGuerreiro = InOut.leString("Digite o nome do Guerreiro: ");

        // Criação do Oráculo Master e do Guerreiro
        Oraculo oraculoMaster = new Oraculo(nomeOraculo);
        Guerreiro guerreiro = new Guerreiro(nomeGuerreiro);

        // Oráculo sorteia vidas para o Guerreiro
        guerreiro.setQtdVidas(oraculoMaster.sortearVidas());

        // Exibe o prólogo do jogo
        InOut.MsgDeInformacao("Introdução", oraculoMaster.prologoIntroducao(guerreiro));

        // Joga a primeira partida (level 1)
      boolean resultadoPartida1 = oraculoMaster.loadLevel1(guerreiro);

      // Estado do Guerreiro após a primeira partida
      InOut.MsgDeInformacao("Estado do Guerreiro após a primeira partida",
          "Nome: " + guerreiro.getNome_guerreiro() + "\nVidas: " + guerreiro.getQtdVidas());

      // Se o Guerreiro perdeu todas as vidas na primeira partida
      if (!resultadoPartida1 && guerreiro.getQtdVidas() <= 0) {
          String pedidoMisericordia = guerreiro.pedirVidaExtra();
          boolean vidaExtraConcedida = oraculoMaster.decidirVidaExtra(pedidoMisericordia);

          if (vidaExtraConcedida) {
              guerreiro.ganharVida(); // Concede uma vida extra
              InOut.MsgDeInformacao("Vida Extra", "Oráculo concedeu uma vida extra. Você tem " + guerreiro.getQtdVidas() + " vidas.");
          } else {
              InOut.MsgDeInformacao("Vida Extra", "Oráculo negou a vida extra. Você perdeu o jogo.");
          }
      }

        // Estado do Guerreiro após a primeira partida
        InOut.MsgDeInformacao("Estado do Guerreiro após a primeira partida",
                "Nome: " + guerreiro.getNome_guerreiro() + "\nVidas: " + guerreiro.getQtdVidas());

        // Joga a segunda partida (level 2)
        boolean resultadoPartida2 = oraculoMaster.loadLevel2(guerreiro);

        // Estado do Guerreiro após a segunda partida
        InOut.MsgDeInformacao("Estado do Guerreiro após a segunda partida",
                "Nome: " + guerreiro.getNome_guerreiro() + "\nVidas: " + guerreiro.getQtdVidas());

        // Exibe o resultado do jogo (baseado nas duas partidas)
        if (resultadoPartida1 && resultadoPartida2) {
            InOut.MsgDeInformacao("Resultado Final", oraculoMaster.prologoVencedor());
        } else {
            InOut.MsgDeInformacao("Resultado Final", oraculoMaster.prologoPerdedor());
        }
    }
}
