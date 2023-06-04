package aps.models;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public  class Truck {
	
	private Image image;
	private int x, y;
	private ArrayList<Hole> holes;
	private int vida;
	private int Velocidade = 1;
	
	public Truck(int x, int y) {
		this.x = x;
		this.y = y;
		holes = new ArrayList<Hole>();
	}
}