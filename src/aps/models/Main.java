package aps.models;

import javax.swing.*;

import aps.container.Container_Aps;

import java.awt.*;
import java.awt.event.*;

public class Main extends JPanel implements ActionListener{
    private Image fundo;
    private Game Game;
 

    public Main() {
        

        // Configuração do painel
        setPreferredSize(new Dimension(400, 300)); // Define o tamanho preferencial do painel
        setLayout(new BorderLayout());

        ImageIcon fundoIcon = new ImageIcon("Imagens\\background_menu.png");
        fundo = fundoIcon.getImage();
        
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
                // Criação e exibição do jogo
            	new Container_Aps();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para sair do jogo
                System.exit(0);
            }
        });

        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250));
        buttonPanel.add(jogarButton);
        buttonPanel.add(sairButton);

        // Adiciona os componentes ao painel
        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Configuração do KeyListener
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
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
        });
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
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Menu do Jogo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Main());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
