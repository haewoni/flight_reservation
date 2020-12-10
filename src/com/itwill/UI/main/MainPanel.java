package com.itwill.UI.main;

import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	FlightReservationMainFrame flightReservationMainFrame;
	/**
	 * Create the panel.
	 * @throws UnsupportedEncodingException 
	 */
	public MainPanel() throws UnsupportedEncodingException {
		setBackground(Color.GRAY);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 680, 680);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		URL imageUrl=getClass().getClassLoader().getResource("image/chicago.jpg");
		System.out.println(imageUrl.getPath());
		lblNewLabel.setIcon(new ImageIcon(imageUrl.getPath()));
		lblNewLabel.setBounds(0, 0, 680, 680);
		panel.add(lblNewLabel);

	}

	public void setMainFrame(FlightReservationMainFrame flightReservationMainFrame) {
		this.flightReservationMainFrame = flightReservationMainFrame;
	}
}
