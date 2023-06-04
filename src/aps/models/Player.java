package aps.models;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends JPanel implements ActionListener {
	private Image image;
	private int altura, largura;
	private int x, y;
	private int dx, dy;
	private int vida, pontuacao;
	private Image imagem;
	
	public Player() {
		this.x = 100;
		this.y = 150;
		pontuacao = 0;

		vida = 4;
//		timer = new Timer(7000, this);
//		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		}
	
	public void load() {
		ImageIcon referencia = new ImageIcon("Imagens\\Caminhao.png");
		image = referencia.getImage();

		altura = image.getHeight(null);
		largura = image.getWidth(null);
	}
	
	public void update() {

		x += dx;
		y += dy;

		if (this.x < 6) {
			x = 6;
		}
		if (this.x > 1000) {
			x = 1000;
		}
		if (this.y < 65) {
			y = 65;
		}
		if (this.y > 515) {
			y = 515;
		}
		setImagemvida();
	}
	
	public void setImagemvida() {
		if (vida == 0) {
			ImageIcon referencia = new ImageIcon("Imagens\\caminhao0life.png");
			image = referencia.getImage();
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	
	public Image getImagem() {
		return image;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public void keyPressed(KeyEvent tecla) {

		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_UP) {
			dy = -3;
		}

		if (codigo == KeyEvent.VK_DOWN) {
			dy = 3;
		}

		if (codigo == KeyEvent.VK_LEFT) {
			dx = -3;
		}

		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 3;
		}
	}
	
	public void keyReleased(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if (codigo == KeyEvent.VK_UP) {
			dy = 0;
		}
		
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		
		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
}
