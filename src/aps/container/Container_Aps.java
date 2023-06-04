package aps.container;

import javax.swing.JButton;
import javax.swing.JFrame;

import aps.models.Game;

public class Container_Aps extends JFrame{
	public Container_Aps() {
		
		add(new Game());
		setTitle("Garbage Collector");
		setSize(1024, 648);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
}