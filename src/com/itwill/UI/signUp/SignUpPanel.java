package com.itwill.UI.signUp;	//회원가입

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.itwill.passenger.Passenger;
import com.itwill.passenger.PassengerDAO;
import com.itwill.passenger.PassengerService;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SignUpPanel extends JPanel {
	
	private PassengerService passseService;
	private PassengerDAO passengerDAO;
	
	private JTextField memberIdTF;
	private JTextField memberPwTF;
	private JTextField confirmmemberPwTF;
	private JTextField memberNameTF;
	private JTextField birthDayTF;
	private JTextField phoneTF;

	/**
	 * Create the panel.
	 */
	public SignUpPanel() {

		setLocation(-12, -24);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 20, 628, 460);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(239, 27, 149, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(125, 113, 90, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(125, 157, 90, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호입력");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(125, 201, 90, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("이름");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(125, 243, 90, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("생년월일");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(125, 291, 90, 15);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("휴대전화");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(125, 332, 90, 15);
		panel.add(lblNewLabel_6);
		
		memberIdTF = new JTextField();
		memberIdTF.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		memberIdTF.setBounds(269, 110, 116, 21);
		panel.add(memberIdTF);
		memberIdTF.setColumns(10);
		
		memberPwTF = new JTextField();
		memberPwTF.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		memberPwTF.setBounds(269, 154, 116, 21);
		panel.add(memberPwTF);
		memberPwTF.setColumns(10);
		
		confirmmemberPwTF = new JTextField();
		confirmmemberPwTF.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		confirmmemberPwTF.setBounds(269, 198, 116, 21);
		panel.add(confirmmemberPwTF);
		confirmmemberPwTF.setColumns(10);
		
		memberNameTF = new JTextField();
		memberNameTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//String confirmMemberPw = 
				
				
				
				
			}
		});
		memberNameTF.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		memberNameTF.setBounds(269, 240, 116, 21);
		panel.add(memberNameTF);
		memberNameTF.setColumns(10);
		
		birthDayTF = new JTextField();
		birthDayTF.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		birthDayTF.setBounds(269, 288, 116, 21);
		panel.add(birthDayTF);
		birthDayTF.setColumns(10);
		
		phoneTF = new JTextField();
		phoneTF.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		phoneTF.setBounds(269, 329, 116, 21);
		panel.add(phoneTF);
		phoneTF.setColumns(10);
		
		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String memberId = memberIdTF.getText();
				System.out.println("memberId ==> "+memberId);
				
				
				if (memberId == null||memberId.equals("")) {
					JOptionPane.showConfirmDialog(null, "아이디를 입력하세요...");
					memberIdTF.requestFocus();
					return;
				}
				
				try {
					Passenger findPassenger = passengerDAO.readOne(memberId);
					if (findPassenger == null||findPassenger.equals("")) {
						memberPwTF.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "중복된 아이디 입니다!!!");
						memberIdTF.requestFocus();
						return;
					}
				} catch (Exception e1) {
					//JOptionPane.showMessageDialog(null, "디 입니다!!!");
					memberPwTF.requestFocus();
					return;
					//e1.printStackTrace();
				}

			}

		});
		btnNewButton.setBounds(443, 109, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("저장");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Passenger> passenger = null;
				
				String memberId = memberIdTF.getText();
				String memberPw = memberPwTF.getText();
				String memberName = memberNameTF.getText();
				String birthDay = birthDayTF.getText();
				String phone = phoneTF.getText();
				//if(noStr.equals("")||ownerStr.equals("")||
				if (memberId.equals("")||memberPw.equals("")||memberName.equals("")||birthDay.equals("")||phone.equals("")) {
					JOptionPane.showMessageDialog(null, "입력하세요!!!");
					memberIdTF.requestFocus();
					return;
				}
				try {
					Passenger pass = new Passenger(memberId, memberPw, memberName, birthDay, phone);
					if ( passseService.passengerRegister(pass)) {
						memberIdTF.setText("");
						memberNameTF.setText("");
						memberNameTF.setText("");
						birthDayTF.setText("");
						phoneTF.setText("");
						memberIdTF.requestFocus();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		btnNewButton_1.setBounds(158, 394, 97, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("취소");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_2.setBounds(352, 394, 97, 23);
		panel.add(btnNewButton_2);
		
	
		


	}
}
