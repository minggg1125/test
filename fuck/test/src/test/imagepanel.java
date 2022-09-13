package test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class imagepanel extends JPanel {
private Image img;
	public imagepanel(Image img) {
		this.img = img;
		this.setSize(img.getWidth(null),img.getHeight(null));
		this.setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		
	}

	
}
