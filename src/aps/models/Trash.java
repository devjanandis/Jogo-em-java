package aps.models;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Trash{

	private Image Imagem;
	private int x, y;
	private Timer timer;
	private int largura, altura;
	private boolean visivel = true;
	
	private static int VELOCIDADE = 2;
	private static final int LARGURA = 1024;
	
	public Trash(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void load() {
		ImageIcon reference = new ImageIcon("Imagens\\SacoLixo.png");
		Imagem = reference.getImage();
		
		this.altura = Imagem.getHeight(null);
		this.largura = Imagem.getWidth(null);
	}
	
	public void update() {
		this.x -= VELOCIDADE;
	}
	
	public int getX() {
		return x;
	}
	
	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.visivel = isVisivel;
	}
	
	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}
	
	public int getY() {
		return y;
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	
	public void setImagem(Image imagem) {
		Imagem = imagem;
	}
	
	public Image getImagem() {
		return Imagem;
	}
}