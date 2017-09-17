package com.bd.anis.rony.helpandsupport;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class CenterHelpAndSupport extends JPanel {
	Image bgImage = Toolkit.getDefaultToolkit().getImage("raw/centerhelpandsupportbg.png");
	/**
	 * Create the panel.
	 */
	public CenterHelpAndSupport() {

	}
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    Dimension d = getSize();
	    if (bgImage != null)
	        g.drawImage(bgImage, 0, 0, d.width, d.height, this);
	}
}
