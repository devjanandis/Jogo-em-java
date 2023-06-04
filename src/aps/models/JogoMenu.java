package aps.models;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;
import javax.swing.ImageIcon;

public class JogoMenu extends JFrame {
	private Image fundo;

    public JogoMenu() {
        super("Menu do Jogo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        
        ImageIcon backgroundImage = new ImageIcon("\\Imagens/background_menu.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        setLayout(null);
        add(backgroundLabel);


        // Criação do título
        JLabel titleLabel = new JLabel("Trash Collector");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Criação dos botões
        JButton jogarButton = new JButton("Jogar");
        JButton sairButton = new JButton("Sair");

        // Configuração dos botões
        jogarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Game jogo1=new Game();
            	jogo1.setVisible(true);
                // Lógica para iniciar o jogo
                JOptionPane.showMessageDialog(null, "Iniciando o jogo...");
            }
        });


        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para sair do jogo
                System.exit(0);
            }
        });

        // Configuração do layout
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 20)); // 3 linhas, 1 coluna, espaço vertical de 20 pixels
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250)); // Espaço em torno dos botões
        buttonPanel.add(jogarButton);
        buttonPanel.add(sairButton);

        // Adiciona os componentes ao JFrame
        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Configuração do KeyListener
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_F3) {
                    // Lógica para aumentar o volume
                    JOptionPane.showMessageDialog(null, "Aumentando o volume...");
                } else if (keyCode == KeyEvent.VK_F2) {
                    // Lógica para diminuir o volume
                    JOptionPane.showMessageDialog(null, "Diminuindo o volume...");
                }
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        // Habilita o foco do KeyListener
        setFocusable(true);
        requestFocus();
    }

    private void abrirOpcoes() {
        // Criação do JOptionPane com as opções de volume
        String[] opcoes = {"Aumentar Volume (F3)", "Diminuir Volume (F2)"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção de volume:", "Opções de Volume", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        // Lógica para as opções de volume
        if (escolha == 0) {
            JOptionPane.showMessageDialog(null, "Aumentando o volume...");
        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null, "Diminuindo o volume...");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JogoMenu menu = new JogoMenu();
                menu.setVisible(true);
            }
        });
    }
}

