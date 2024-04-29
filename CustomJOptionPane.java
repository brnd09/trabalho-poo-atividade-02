import javax.swing.*;
import java.awt.*;

public class CustomJOptionPane {

    public static void setCustomBackgroundColor(Color color) {
        UIManager.put("OptionPane.background", color);
        UIManager.put("Panel.background", color);
    }

    public static void main(String[] args) {
        // Teste a cor de fundo personalizada
        setCustomBackgroundColor(Color.CYAN);

        String nome = JOptionPane.showInputDialog(null, "Digite o seu nome:", "Entrada de dados", JOptionPane.QUESTION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Seu nome é " + nome, "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
    }
}
