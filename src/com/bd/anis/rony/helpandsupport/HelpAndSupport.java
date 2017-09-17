package com.bd.anis.rony.helpandsupport;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.Icon;

public class HelpAndSupport extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image bgImage = Toolkit.getDefaultToolkit().getImage("raw/bg.png");

	ImageIcon removeButtonIcon = new ImageIcon("raw/removebutton.png");
	ImageIcon removeButtonIcon1 = new ImageIcon("raw/removebutton1.png");
	
	ImageIcon selectallButtonIcon = new ImageIcon("raw/selectallbutton.png");
	ImageIcon selectallButtonIcon1 = new ImageIcon("raw/selectallbutton1.png");
	
	ImageIcon lockButtonIcon = new ImageIcon("raw/lockbutton.png");
	ImageIcon lockButtonIcon1 = new ImageIcon("raw/lockbutton1.png");
	
	ImageIcon unlockButtonIcon = new ImageIcon("raw/unlockbutton.png");
	ImageIcon unlockButtonIcon1 = new ImageIcon("raw/unlockbutton1.png");
	
	ImageIcon helpIcon = new ImageIcon("raw/help.png");
	ImageIcon fbIcon = new ImageIcon("raw/facebook.png");
	ImageIcon youtubeicon = new ImageIcon("raw/youtube.png");
	ImageIcon googleplusicon = new ImageIcon("raw/googleplus.png");
	ImageIcon twitter = new ImageIcon("raw/twitter.png");

	
	/**
	 * Create the panel.
	 */
	public HelpAndSupport() {
		setLayout(null);
		
		JPanel centerHelpAndSupport = new CenterHelpAndSupport();
		centerHelpAndSupport.setBackground(Color.DARK_GRAY);
		centerHelpAndSupport.setBounds(10, 11, 870, 385);
		add(centerHelpAndSupport);
		GroupLayout gl_panel = new GroupLayout(centerHelpAndSupport);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 837, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 298, Short.MAX_VALUE)
		);
		centerHelpAndSupport.setLayout(gl_panel);
		
		JPanel footer = new JPanel();
		footer.setBackground(SystemColor.inactiveCaption);
		footer.setBounds(10, 407, 870, 65);
		add(footer);
		
		JButton btnUserGuide = new JButton(fbIcon);
		btnUserGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		          if (Desktop.isDesktopSupported()) {
		                Desktop desktop = Desktop.getDesktop();
		                try {
		                    URI uri = new URI("http://www.facebook.com/AnisBulbl");
		                    desktop.browse(uri);
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                } catch (URISyntaxException ex) {
		                    ex.printStackTrace();
		                }
		        }
			}
		});
		
		JButton backuplockerButton = new JButton("Delect All");
		JButton btnUg = new JButton(helpIcon);
		btnUg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					File file = new File("help/manual.doc");
					String filePath = file.getAbsolutePath();
					System.out.println(filePath);
					String cmds[] = new String[] {"cmd", "/c", filePath};
					Process process = Runtime.getRuntime().exec( cmds );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton button = new JButton(youtubeicon);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

		          if (Desktop.isDesktopSupported()) {
		                Desktop desktop = Desktop.getDesktop();
		                try {
		                    URI uri = new URI("http://www.youtube.com/fss");
		                    desktop.browse(uri);
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                } catch (URISyntaxException ex) {
		                    ex.printStackTrace();
		                }
		        }
			
			}
		});
		
		JButton button_1 = new JButton(googleplusicon);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

		          if (Desktop.isDesktopSupported()) {
		                Desktop desktop = Desktop.getDesktop();
		                try {
		                    URI uri = new URI("http://plus.google.com/fss");
		                    desktop.browse(uri);
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                } catch (URISyntaxException ex) {
		                    ex.printStackTrace();
		                }
		        }
			
			}
		});
		
		JButton button_2 = new JButton(twitter);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

		          if (Desktop.isDesktopSupported()) {
		                Desktop desktop = Desktop.getDesktop();
		                try {
		                    URI uri = new URI("http://www.twitter.com/fss");
		                    desktop.browse(uri);
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                } catch (URISyntaxException ex) {
		                    ex.printStackTrace();
		                }
		        }
			
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(footer);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnUg, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUserGuide, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(581, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUserGuide, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
						.addComponent(btnUg, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		footer.setLayout(gl_panel_1);
	}
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    Dimension d = getSize();
	    if (bgImage != null)
	        g.drawImage(bgImage, 0, 0, d.width, d.height, this);
	}
}