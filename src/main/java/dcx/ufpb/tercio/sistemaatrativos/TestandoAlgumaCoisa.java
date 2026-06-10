package dcx.ufpb.tercio.sistemaatrativos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestandoAlgumaCoisa extends JFrame {
    JLabel linha1;
    ImageIcon MinhaOC = new ImageIcon("./assets/imgs/icon_random.jpg");
    public TestandoAlgumaCoisa() {
       setTitle("Testando");
       setSize(600, 600);
       setLocation(0, 0);
       setResizable(true);
        getContentPane().setBackground(Color.pink);
        linha1 = new JLabel(MinhaOC, JLabel.CENTER);
        getContentPane().add(linha1); // Adiciona a Linha1 dentro do Painel
    }

    public static void main(String [] args) {
        TestandoAlgumaCoisa novaJanela = new TestandoAlgumaCoisa();
        novaJanela.setVisible(true);
        WindowListener fechadorJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };
        novaJanela.addWindowListener(fechadorJanelaPrincipal);
    }
}
