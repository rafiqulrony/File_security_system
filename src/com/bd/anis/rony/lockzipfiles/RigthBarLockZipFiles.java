package com.bd.anis.rony.lockzipfiles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class RigthBarLockZipFiles extends JPanel {
	Image bgImage = Toolkit.getDefaultToolkit().getImage("raw/rigthbarLockfilesbg.png");
	/**
	 * Create the panel.
	 */
	public RigthBarLockZipFiles() {
	}
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    Dimension d = getSize();
	    if (bgImage != null)
	        g.drawImage(bgImage, 0, 0, d.width, d.height, this);
	}
}
