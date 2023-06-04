package aps.models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {

	private Image fundo;
	private Player player;
	private List<Hole> holes;
	private List<Trash> trash;
	private Timer timer;
	private List<Traco> tracos;
	private boolean emJogo;
	private int tempo = 0;

	public Game() {
		setFocusable(true);
		setDoubleBuffered(true);

		addKeyListener(new KeyboardAdapter());

		ImageIcon referencia = new ImageIcon("Imagens\\Background1.png");
		fundo = referencia.getImage();

		player = new Player();
		player.load();

		// waitForSeconds();
		timer = new Timer(5, this);
		timer.start();

		inicializaTraco();
		inicializaBuracos();
		inicializaLixos();
		emJogo = true;
	}

	public void inicializaTraco() {
		int cordenadas[] = new int[100];
		tracos = new ArrayList<Traco>();
		int x = 0;
		int y = 20;
		for (int i = 0; i < cordenadas.length; i++) {
			x += 150;
			tracos.add(new Traco(x, y));
		}
	}

	public void inicializaBuracos() {
		int cordenadas[] = new int[25];
		holes = new ArrayList<Hole>();
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int) (Math.random() * 8000 + 1024);
			int y = (int) (Math.random() * 500 + 30);
			holes.add(new Hole(x, y));
		}
	}

	public void inicializaLixos() {
		int cordenadas[] = new int[14];
		trash = new ArrayList<Trash>();
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int) (Math.random() * 8000 + 100);
			int y = (int) (Math.random() * 500 + 30);
			trash.add(new Trash(x, y));
		}
	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		if (emJogo) {
			graficos.drawImage(fundo, 0, 0, null);

			for (int k = 0; k < tracos.size(); k++) {
				Traco on = tracos.get(k);
				on.load();
				graficos.drawImage(on.getImagem(), on.getX(), on.getY(), null);
			}

			for (int k = 0; k < trash.size(); k++) {
				Trash on = trash.get(k);
				on.load();
				graficos.drawImage(on.getImagem(), on.getX(), on.getY(), null);
			}

			for (int k = 0; k < holes.size(); k++) {
				Hole on = holes.get(k);
				on.load();
				graficos.drawImage(on.getImagem(), on.getX(), on.getY(), null);
			}

			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

			ImageIcon tamplate1 = new ImageIcon("Imagens\\PainelVida.png");
			graficos.drawImage(tamplate1.getImage(), 5, 10, null);

			int a = 5;
			for (int j = 0; j < player.getVida(); j++) {
				ImageIcon vida = new ImageIcon("Imagens\\Vida.png");
				graficos.drawImage(vida.getImage(), a, 20, null);
				a += 30;
			}
		} else {
			if (player.getVida() <= 0) {
				ImageIcon fimJogo = new ImageIcon("Imagens\\fimdejogo.png");
				graficos.drawImage(fimJogo.getImage(), 0, 0, null);
			} else if (player.getPontuacao() > 6) {
				ImageIcon fimJogo = new ImageIcon("Imagens\\Vitoria.png");
				graficos.drawImage(fimJogo.getImage(), 0, 0, null);
			} else {
				ImageIcon fimJogo = new ImageIcon("Imagens\\Derrota.png");
				graficos.drawImage(fimJogo.getImage(), 0, 0, null);
			}
		}

		g.dispose();
	}

	public void checarColisoes() {
		Rectangle formacaminhao = player.getBounds();
		Rectangle formaburaco;
		Rectangle formalixo;

		for (int i = 0; i < trash.size(); i++) {
			Trash temptrash = trash.get(i);
			formalixo = temptrash.getBounds();

			if (formacaminhao.intersects(formalixo)) {
				player.setPontuacao(player.getPontuacao() + 1);

				temptrash.setVisivel(false);
			}
		}

		for (int i = 0; i < holes.size(); i++) {
			Hole temphole = holes.get(i);
			formaburaco = temphole.getBounds();

			if (formacaminhao.intersects(formaburaco)) {
				player.setVida(player.getVida() - 1);

				temphole.setVisivel(false);
				if (player.getVida() == 0) {
					emJogo = false;
				}
			}
		}
	}

	private void fimDeJogo() {
		if (tempo > 3000) {
			emJogo = false;
		}
	}

	private class KeyboardAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (emJogo) {
			player.update();

			for (int p = 0; p < tracos.size(); p++) {
				Traco on = tracos.get(p);
				if (on.isVisivel()) {
					on.update();
				} else {
					tracos.remove(p);
				}
			}

			for (int i = 0; i < holes.size(); i++) {
				Hole n = holes.get(i);
				if (n.isVisivel()) {
					n.update();
				} else {
					holes.remove(n);
				}
			}

			for (int i = 0; i < trash.size(); i++) {
				Trash n = trash.get(i);
				if (n.isVisivel()) {
					n.update();
				} else {
					trash.remove(n);
				}
			}
			tempo++;
			fimDeJogo();
			checarColisoes();
			repaint();
		}
	}
}
