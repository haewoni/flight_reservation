package com.itwill.UI.updatePassenger;	//회원정보 수정 및 탈퇴

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.UI.main.FlightReservationMainFrame;
import com.itwill.passenger.Passenger;
import com.itwill.passenger.PassengerService;
import javax.swing.JPasswordField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class UpdatePassengerPanel extends JPanel {
	/************************************************/
	PassengerService passengerService;
	FlightReservationMainFrame flightReservationMainFrame;
	/************************************************/
	private JTextField idTF;
	private JTextField nameTF;
	private JTextField birthDateTF;
	private JTextField phoneNoTF;
	private JButton pswConfirmButton;
	private JButton deleteAccountButton;
	private JCheckBox messageRecevieCHK;
	private JPasswordField rePswTF;
	private JPasswordField newPswTF;
	
	
	/**
	 * Create the panel.
	 */
	public UpdatePassengerPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				idTF.setText(flightReservationMainFrame.loginPassenger.getMemberId());
				nameTF.setText(flightReservationMainFrame.loginPassenger.getMemberName());
				birthDateTF.setText(flightReservationMainFrame.loginPassenger.getBirthDate());
				phoneNoTF.setText(flightReservationMainFrame.loginPassenger.getPhoneNo());
				
			}
		});
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JLabel titleLabel = new JLabel("내 계정 정보");
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(267, 38, 146, 72);
		add(titleLabel);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(157, 161, 84, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호 재입력");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(95, 208, 131, 21);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("새 비밀번호");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(122, 250, 84, 21);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("이름");
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(172, 293, 84, 21);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("생년월일");
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(142, 338, 84, 21);
		add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("휴대전화");
		lblNewLabel_1_1_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(142, 385, 84, 21);
		add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("문자수신여부");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(111, 431, 104, 21);
		add(lblNewLabel_1_1_1_1_1_1);
		
		idTF = new JTextField();
		idTF.setEditable(false);
		idTF.setBounds(270, 158, 131, 21);

		idTF.setColumns(10);
		add(idTF);
		
		nameTF = new JTextField();
		
		nameTF.setEditable(false);
		nameTF.setColumns(10);
		nameTF.setBounds(270, 292, 131, 21);
		add(nameTF);
		
		birthDateTF = new JTextField();
		
		birthDateTF.setEditable(false);
		birthDateTF.setColumns(10);
		birthDateTF.setBounds(270, 337, 131, 21);
		add(birthDateTF);
		
		phoneNoTF = new JTextField();
		
		phoneNoTF.setEditable(false);
		phoneNoTF.setColumns(10);
		phoneNoTF.setBounds(270, 384, 131, 21);
		add(phoneNoTF);
		
		messageRecevieCHK = new JCheckBox("");
		messageRecevieCHK.setEnabled(false);
		messageRecevieCHK.setBounds(271, 429, 21, 23);
		add(messageRecevieCHK);
		
		///확인 버튼 누르면 하단 TF 활성화
		pswConfirmButton = new JButton("확인");
		pswConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Passenger passengerId = passengerService.findById(idTF.getText());
					if(rePswTF.getText().equals(passengerId.getMemberPw())) {
						JOptionPane.showMessageDialog(null, "확인 되었습니다");
						rePswTF.setEditable(true);
						newPswTF.setEditable(true);
						newPswTF.enable(true);
						nameTF.setEditable(true);
						birthDateTF.setEditable(true);
						phoneNoTF.setEditable(true);
						messageRecevieCHK.setEnabled(true);
						deleteAccountButton.setEnabled(true);
						newPswTF.requestFocus();
						
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}  //아이디 불러오기
			}
		}); 
		pswConfirmButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswConfirmButton.setBounds(426, 208, 64, 23);
		add(pswConfirmButton);
		/*
		 * 1. 메인화면으로 이동 (JFrame)
		 * 2. 회원정보 ArrayList에서 삭제
		 */
		deleteAccountButton = new JButton("회원탈퇴");  
		deleteAccountButton.setEnabled(false);
		deleteAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "탈퇴 되었습니다");
			flightReservationMainFrame.logout();
			try {
				passengerService.memberDelete(idTF.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		deleteAccountButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		deleteAccountButton.setBounds(502, 208, 84, 23);
		add(deleteAccountButton);
		
		JButton editButton = new JButton("수정");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
					updateMember();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}     
			}
		});
		editButton.setBounds(218, 529, 97, 23);
		add(editButton);
		/*
		 * 취소 누르면 검색화면으로 다시 이동 --JFrame
		 */
		JButton cancelButton = new JButton("취소");
		cancelButton.setBounds(364, 529, 97, 23);
		add(cancelButton);
		
		rePswTF = new JPasswordField();
		rePswTF.setBounds(270, 210, 131, 21);
		add(rePswTF);
		
		newPswTF = new JPasswordField();
		newPswTF.setEnabled(false);
		newPswTF.setEditable(false);
		newPswTF.setBounds(270, 252, 131, 21);
		add(newPswTF);
		
		//passenger service 생성자
		try {
			passengerService = new PassengerService();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		


	}

	protected void updateMember() throws Exception {
		/*
		 * 수정완료시 TF 비활성화
		 */
		JOptionPane.showMessageDialog(null, "수정 되었습니다");
		newPswTF.setEditable(false);
		nameTF.setEditable(false);
		birthDateTF.setEditable(false);
		phoneNoTF.setEditable(false);
		messageRecevieCHK.setEnabled(false);
		deleteAccountButton.setEnabled(false);
		rePswTF.requestFocus();
		/*
		 * 회원정보 ArrayList에 수정사항 반영
		 */
		String id = idTF.getText();
		String pw = newPswTF.getText();
		String name = nameTF.getText();
		String birthDate = birthDateTF.getText();
		String phoneNo = phoneNoTF.getText();
		
	
		passengerService.memberUpdate(new Passenger(id, pw, name, birthDate, phoneNo));   //비밀번호 변경 안할 시
		
		
	
		
	}

	public void setMainFrame(FlightReservationMainFrame flightReservationMainFrame) {
		this.flightReservationMainFrame=flightReservationMainFrame;
		
	}

	
}


 