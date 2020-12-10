package com.itwill.UI.reservationList;

import javax.swing.JPanel;

import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.UI.main.FlightReservationMainFrame;
import com.itwill.flight.Flight;
import com.itwill.flight.FlightDAO;
import com.itwill.passenger.Passenger;
import com.itwill.passenger.PassengerService;
import com.itwill.reservation.Reservation;
import com.itwill.reservation.ReservationDAO;
import com.itwill.reservation.ReservationService;

import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class ReservationFindPanel extends JPanel {
	private JTable airTicketTable;
	/*****************************************************************/
	ReservationService reservationService;
	PassengerService passengerService;
	private ArrayList<Reservation> reservationList;
	String loginId = "";
	private JTable travelInfoTable;
	private JTextField nameTF;
	private JTextField birthTF;
	private JTextField phoneNoTF;
	private JTextField reserveNoTF;
	private JCheckBox agreeCheckBox;
	FlightReservationMainFrame flightReservationMainFrame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton searchBtn;

	/*****************************************************************/

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public ReservationFindPanel() throws Exception {
		addComponentListener(new ComponentAdapter()   {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					getMemberList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("focus");
			}
		});

		setBackground(new Color(102, 153, 255));
		setLayout(null);

		JTextArea myReserve = new JTextArea();
		myReserve.setForeground(new Color(255, 255, 255));
		myReserve.setBackground(new Color(102, 153, 255));
		myReserve.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		myReserve.setText("MY 예약 내역");
		myReserve.setBounds(266, 10, 120, 32);
		add(myReserve);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("회원 정보");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(new Color(102, 153, 255));
		rdbtnNewRadioButton.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(20, 47, 90, 23);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("항공권 정보");
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setBackground(new Color(102, 153, 255));
		rdbtnNewRadioButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setBounds(20, 155, 95, 23);
		add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("탑승객 및 항공여행 정보");
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_2.setBackground(new Color(102, 153, 255));
		rdbtnNewRadioButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_2.setBounds(20, 430, 177, 23);
		add(rdbtnNewRadioButton_2);

		JScrollPane airlineTicketInfoScrollP = new JScrollPane();
		airlineTicketInfoScrollP.setBounds(20, 184, 600, 116);
		add(airlineTicketInfoScrollP);

		airTicketTable = new JTable();
		airTicketTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		airTicketTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int selectRow = airTicketTable.getSelectedRow();
				if (selectRow == -1) {
					return;
				}
				int selectReserveNo = (Integer) airTicketTable.getModel().getValueAt(selectRow, 0);
				reserveNoTF.setText(selectReserveNo + "");
				
				
			}
		});
		airTicketTable.setForeground(Color.BLACK);
		airTicketTable.setBackground(Color.WHITE);
		airTicketTable.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		airTicketTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "", "\uC5EC\uC815", "\uD56D\uACF5\uD3B8", "\uCD9C\uBC1C\uC77C\uC2DC",
						"\uB3C4\uCC29\uC77C\uC2DC", "\uC88C\uC11D\uAD6C\uBD84", "\uC608\uC57D\uC0C1\uD0DC" }));
		airlineTicketInfoScrollP.setViewportView(airTicketTable);

		agreeCheckBox = new JCheckBox("  상기 내용을 확인하고 동의합니다.");
		agreeCheckBox.setBackground(new Color(230, 230, 250));
		agreeCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		agreeCheckBox.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 11));
		agreeCheckBox.setBounds(71, 324, 240, 23);
		agreeCheckBox.setSelected(false);
		add(agreeCheckBox);

		JButton changeBtn = new JButton("예매 변경"); // 변경버튼 누르면 검색화면으로 이동해야 합니다 ~
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (agreeCheckBox.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "상기내용 확인후 동의해 주세요 !");
				} else if (reserveNoTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "여정을 선택해 주세요");
				}else {
					JOptionPane.showMessageDialog(null, "선택여정 삭제 후 변경화면으로 넘어갑니닷, 이용해주셔서 감사합니다 !!");
					deleteReservation();
					flightReservationMainFrame.changePanel("reservationP");
				}
			 }
		 }
		);
		changeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		changeBtn.setBounds(71, 353, 108, 38);
		add(changeBtn);

		JButton cancelBtn = new JButton("예매 취소");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (agreeCheckBox.isSelected() == false && reserveNoTF != null) {
					JOptionPane.showMessageDialog(null, "상기내용 확인후 동의 해주세요 ~!!");
				} else if (reserveNoTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "여정을 선택해 주세요 !!!!!!!");
				} else if (JOptionPane.showConfirmDialog(null, "예매내역을 삭제 하시겠습니까????? 정말????", "예매내역 삭제",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					deleteReservation();
				}

				try {
					getMemberList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		cancelBtn.setBounds(203, 353, 108, 38);
		add(cancelBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 459, 590, 107);
		add(scrollPane);

		travelInfoTable = new JTable();
		travelInfoTable.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		travelInfoTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, },
				new String[] { "\uD0D1\uC2B9\uAC1D", "\uD2F0\uCF13 \uBC88\uD638", "\uD56D\uACF5 \uC694\uAE08" }));
		scrollPane.setViewportView(travelInfoTable);

		lblNewLabel = new JLabel("성명 : ");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel.setBounds(70, 76, 50, 15);
		add(lblNewLabel);

		lblNewLabel_1 = new JLabel("생년월일 : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_1.setBounds(57, 114, 80, 15);
		add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("연락처 : ");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_2.setBounds(344, 76, 67, 15);
		add(lblNewLabel_2);

		nameTF = new JTextField();
		nameTF.setEditable(false);
		nameTF.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		nameTF.setBounds(168, 75, 96, 21);
		add(nameTF);
		nameTF.setColumns(10);

		birthTF = new JTextField();
		birthTF.setEditable(false);
		birthTF.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		birthTF.setBounds(168, 113, 96, 21);
		add(birthTF);
		birthTF.setColumns(10);

		phoneNoTF = new JTextField();
		phoneNoTF.setEditable(false);
		phoneNoTF.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		phoneNoTF.setBounds(438, 73, 163, 38);
		add(phoneNoTF);
		phoneNoTF.setColumns(10);

		reserveNoTF = new JTextField();
		reserveNoTF.setBounds(457, 326, 163, 21);
		add(reserveNoTF);
		reserveNoTF.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("예약번호 : ");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3.setBounds(379, 322, 80, 24);
		add(lblNewLabel_3);
		
		searchBtn = new JButton("예약번호로 조회하기");
		searchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tripInfo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		searchBtn.setBounds(438, 431, 182, 23);
		add(searchBtn);

		reservationService = new ReservationService();
		passengerService = new PassengerService();
		getMemberList();
		

	}

	protected void deleteReservation() {
		try {
			Integer deleteNo = Integer.parseInt(reserveNoTF.getText());
			if (deleteNo == null || agreeCheckBox.isSelected() == false)
				return;

			if (JOptionPane.YES_OPTION == 0) {
				reservationService.remove(deleteNo);
				reserveNoTF.setText("");
				JOptionPane.showMessageDialog(null, "여정 예매가 성공적으로 삭제되었습니다 ! 이용해주셔서 감사합니다 -!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		{

		}

	}

	protected void getMemberList() throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>"+loginId);
		ArrayList<Reservation> reservationList = reservationService.findById(loginId);

		// DefaultListModel listModel = new DefaultListModel();

		// DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

		DefaultTableModel tableModel1 = new DefaultTableModel();
		Vector columnVector1 = new Vector();

		columnVector1.add("티켓번호");
		columnVector1.add("항공사");
		columnVector1.add("여정");
		columnVector1.add("항공편");
		columnVector1.add("출발일시");
		columnVector1.add("도착일시");

		tableModel1.setColumnIdentifiers(columnVector1);

		for (Reservation reservation : reservationList) {
			// listModel.addElement(flight.getFlightName());
			// comboBoxModel.addElement(flight.getFlightName());

			Vector rowVector1 = new Vector();

			rowVector1.add(reservation.getReservationNo());
			rowVector1.add(reservation.getFlight().getAirlineName());
			rowVector1.add(reservation.getFlight().getStartPoint() + " -> " + reservation.getFlight().getFinishPoint());
			rowVector1.add(reservation.getFlight().getFlightName());
			rowVector1.add(reservation.getFlight().getFlightStartYear() + "/"
					+ reservation.getFlight().getFlightStartMonth() + "/" + reservation.getFlight().getFlightStartDay()
					+ "-" + reservation.getFlight().getFlightStartTime());
			rowVector1.add(
					reservation.getFlight().getFlightFinishYear() + "/" + reservation.getFlight().getFlightFinishMonth()
							+ "/" + reservation.getFlight().getFlightFinishDay() + "-"
							+ reservation.getFlight().getFlightFinishTime());
			

			tableModel1.addRow(rowVector1);

		}

		airTicketTable.setModel(tableModel1);
		String tempName = "";
		String tempPhoneNo = "";
		String tempBirth = "";
		for (Reservation reservation : reservationList) {
			if (reservation.getPassenger().getMemberId().equals(loginId)) {
				reservation.getPassenger().getMemberName();
				tempName = reservation.getPassenger().getMemberName();
				tempPhoneNo = reservation.getPassenger().getPhoneNo();
				tempBirth = reservation.getPassenger().getBirthDate();
			}
		}
		nameTF.setText(tempName);
		phoneNoTF.setText(tempPhoneNo);
		birthTF.setText(tempBirth);

		// System.out.println(adultCount);
		// System.out.println(this.seatRating);
	}

	

	public void setMainFrame(FlightReservationMainFrame flightReservationMainFrame) {
		this.flightReservationMainFrame=flightReservationMainFrame;
		loginId=flightReservationMainFrame.loginId;
	}
	
	protected void tripInfo() throws Exception {
		Reservation reservation = reservationService.findByNo(Integer.parseInt(reserveNoTF.getText()));

		// DefaultListModel listModel = new DefaultListModel();

		// DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

		DefaultTableModel tableModel2 = new DefaultTableModel();
		Vector columnVector2 = new Vector();

		columnVector2.add("탑승객");
		columnVector2.add("항공요금");
		columnVector2.add("좌석구분");
		columnVector2.add("예약상태");

		tableModel2.setColumnIdentifiers(columnVector2);

		
			// listModel.addElement(flight.getFlightName());
			// comboBoxModel.addElement(flight.getFlightName());

			Vector rowVector2 = new Vector();

			//flightReservationMainFrame.loginPassenger.getMemberId()
			rowVector2.add("성인 : "+reservation.getAdultCount()+"명 / 소아 : "+reservation.getChildCount()+"명");
			rowVector2.add(reservation.getReservationFee()+"원");
			rowVector2.add(reservation.getSeatRating());
			rowVector2.add(true);

			tableModel2.addRow(rowVector2);

		

		travelInfoTable.setModel(tableModel2);
		// System.out.println(adultCount);
		// System.out.println(this.seatRating);
	}
}
