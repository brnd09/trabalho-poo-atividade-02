public class Guerreiro {
    private String nome_guerreiro;
    private int qtdVidas;

    public Guerreiro(String nome) {
        this.nome_guerreiro = nome;
        this.qtdVidas = 0;
    }

    public void ganharVida() {
        this.qtdVidas++;
    }

    public void perderVida() {
        this.qtdVidas--;
    }

    public String getNome_guerreiro() {
        return nome_guerreiro;
    }

    public int getQtdVidas() {
        return qtdVidas;
    }

    public void setQtdVidas(int qtdVidas) {
        this.qtdVidas = qtdVidas;
    }

    // Defina o método para pedir uma vida extra
    public String pedirVidaExtra() {
        return InOut.leString("Guerreiro " + nome_guerreiro + ", faça um pedido por uma vida extra: ");
    }
}
