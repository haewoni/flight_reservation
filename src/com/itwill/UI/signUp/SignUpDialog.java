package com.itwill.UI.signUp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.UI.logIn.LoginDialog;
import com.itwill.UI.main.FlightReservationMainFrame;
import com.itwill.passenger.Passenger;
import com.itwill.passenger.PassengerDAO;
import com.itwill.passenger.PassengerService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class SignUpDialog extends JDialog {
	FlightReservationMainFrame flightReservationMainFrame;
	private PassengerService passengerService;
	private PassengerDAO passengerDAO;
	
	private JTextField memberIdTF;
	private JTextField memberNameTF;
	private JTextField birthDayTF;
	private JTextField phoneTF;
	
	private final JPanel contentPanel = new JPanel();
	private JPasswordField confirmpasswordFd;
	private JPasswordField passwordFd;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignUpDialog dialog = new SignUpDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SignUpDialog() {
		setBounds(100, 100, 620, 460);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 20, 628, 460);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(239, 0, 149, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(125, 86, 90, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(125, 130, 90, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호 확인");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(125, 174, 90, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("이름");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(125, 216, 90, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("생년월일");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(125, 264, 90, 15);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("휴대전화");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(125, 305, 90, 15);
		panel.add(lblNewLabel_6);
		
		memberIdTF = new JTextField();
		memberIdTF.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		memberIdTF.setBounds(269, 83, 116, 21);
		panel.add(memberIdTF);
		memberIdTF.setColumns(10);
		
		memberNameTF = new JTextField();
		memberNameTF.addFocusListener(new FocusAdapter() {
		});
		memberNameTF.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		memberNameTF.setBounds(269, 213, 116, 21);
		panel.add(memberNameTF);
		memberNameTF.setColumns(10);
		
		birthDayTF = new JTextField();
		birthDayTF.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		birthDayTF.setBounds(269, 261, 116, 21);
		panel.add(birthDayTF);
		birthDayTF.setColumns(10);
		
		phoneTF = new JTextField();
		phoneTF.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		phoneTF.setBounds(269, 302, 116, 21);
		panel.add(phoneTF);
		phoneTF.setColumns(10);
		
		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String memberId = memberIdTF.getText();
				
				
				if (memberId == null||memberId.equals("")) {
					JOptionPane.showConfirmDialog(null, "아이디를 입력하세요");
					memberIdTF.requestFocus();
					return;
				}
				
				try {
					Passenger findPassenger = passengerDAO.readOne(memberId);
					if (findPassenger == null||findPassenger.equals("")) {
						passwordFd.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "중복된 아이디 입니다");
						memberIdTF.requestFocus();
						return;
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다");
					passwordFd.requestFocus();
					return;
				}

			}

		});
		btnNewButton.setBounds(443, 82, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("가입");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String memberId = memberIdTF.getText();
				String memberPw = String.valueOf(passwordFd.getPassword());
				String confirmPw = String.valueOf(confirmpasswordFd.getPassword());
				String memberName = memberNameTF.getText();
				String birthDay = birthDayTF.getText();
				String phone = phoneTF.getText();

				if (memberId.equals("")||memberPw.equals("")||confirmPw.equals("")||memberName.equals("")||birthDay.equals("")||phone.equals("")) {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요");
					memberIdTF.requestFocus();
					return;
				}
				
			try {
					PassengerService passengerService = new PassengerService();
					boolean isSuccess=  passengerService.passengerRegister(new Passenger(memberId, memberPw, memberName, birthDay, phone));
					
					if ( isSuccess) {
						JOptionPane.showMessageDialog(null, "축하합니다. 가입 되었습니다");
						memberIdTF.setText("");
						memberNameTF.setText("");
						passwordFd.setText("");
						confirmpasswordFd.setText("");
						birthDayTF.setText("");
						phoneTF.setText("");
						memberIdTF.requestFocus();
						dispose();
						LoginDialog loginDialog = new LoginDialog();
						loginDialog.setMainFrame(flightReservationMainFrame);
						loginDialog.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "가입에 실패했습니다. 다시 시도하세요.");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBounds(158, 367, 97, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("취소");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(352, 367, 97, 23);
		panel.add(btnNewButton_2);
		
		confirmpasswordFd = new JPasswordField();
		confirmpasswordFd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				String memberPw = String.valueOf(passwordFd.getPassword());
				String confirmMemberPw = String.valueOf(confirmpasswordFd.getPassword());
				
				if (memberPw.equals(confirmMemberPw)) {

				} else {
					JOptionPane.showMessageDialog(null, "올바른 비밀번호가 아닙니다. 다시 시도하세요");
					confirmpasswordFd.setText("");
					confirmpasswordFd.requestFocus();					
				}
				
			}
		});
		confirmpasswordFd.setBounds(269, 172, 119, 21);
		panel.add(confirmpasswordFd);
		
		passwordFd = new JPasswordField();
		passwordFd.setBounds(269, 128, 119, 21);
		panel.add(passwordFd);
		
	}

	public void setMainFrame(FlightReservationMainFrame flightReservationMainFrame) {
		this.flightReservationMainFrame=flightReservationMainFrame;
		
	}
}
