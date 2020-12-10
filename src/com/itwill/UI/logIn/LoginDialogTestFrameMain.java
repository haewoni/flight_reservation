package com.itwill.UI.logIn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.UI.reservation.ReservationPanel;
import com.itwill.reservation.ReservationService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginDialogTestFrameMain extends JFrame {

	private JPanel contentPane;
	private ReservationService frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDialogTestFrameMain frame = new LoginDialogTestFrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginDialogTestFrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		contentPane.add(panel_3, BorderLayout.CENTER);
	}
	public void showLoginDialog() throws Exception {
		LoginDialog loginDialog = new LoginDialog();
		loginDialog.setVisible(true);
	}
	public void setFrame(ReservationService reservationServiceFrameMain) {
		this.frame = reservationServiceFrameMain;
	}

}
