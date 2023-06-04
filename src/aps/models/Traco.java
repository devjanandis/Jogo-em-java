package aps.models;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Traco{
	private Image Imagem, imagem2;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;

	private static final int LARGURA = 1024;
	private static int VELOCIDADE = 2;

	public Traco(int x, int y) {
		this.x = x;
		this.y = y;
		isVisivel = true;
	}

	public void load() {
		ImageIcon referencia = new ImageIcon("Imagens\\Tracocorreto.png");
		Imagem = referencia.getImage();

		this.altura = Imagem.getHeight(null);
		this.largura = Imagem.getWidth(null);
	}

	public void update() {
			this.x -= VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public Image getImagem() {
		return Imagem;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
}