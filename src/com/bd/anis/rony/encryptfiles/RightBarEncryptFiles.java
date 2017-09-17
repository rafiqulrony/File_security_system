package com.bd.anis.rony.encryptfiles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class RightBarEncryptFiles extends JPanel {
	Image bgImage = Toolkit.getDefaultToolkit().getImage("raw/rightbarencryptfiles.png");
	/**
	 * Create the panel.
	 */
	public RightBarEncryptFiles() {

	}
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    Dimension d = getSize();
	    if (bgImage != null)
	        g.drawImage(bgImage, 0, 0, d.width, d.height, this);
	}
}
