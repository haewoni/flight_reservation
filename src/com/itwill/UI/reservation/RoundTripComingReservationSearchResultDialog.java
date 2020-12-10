package com.itwill.UI.reservation;

import java.awt.BorderLayout;import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.UI.main.FlightReservationMainFrame;
import com.itwill.flight.Flight;
import com.itwill.flight.FlightDAO;
import com.itwill.passenger.Passenger;
import com.itwill.passenger.PassengerService;
import com.itwill.reservation.Reservation;
import com.itwill.reservation.ReservationService;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class RoundTripComingReservationSearchResultDialog extends JDialog {

	/***************************************************************/
	ReservationPanel reservationPanel;
	PassengerService passengerService;
	ReservationService reservationService;
	FlightReservationMainFrame flightReservationMainFrame;
	/***************************************************************/
	
	private final JPanel contentPanel = new JPanel();
	private ArrayList<Flight> flightList;
	private int adultCount;
	private int childCount;
	private String seatRating;
	private double fee;
	private String reserveFlightName;
	private String memberId;

	private JTable searchResultT;
	private JTextField seatRatingTF;
	private JTextField feeTF;
	private JTextArea PassengerTypeTA;
	private JRadioButton reserveCheck;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public RoundTripComingReservationSearchResultDialog() throws Exception {
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("오는날 예약");
		setBounds(100, 100, 855, 423);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(5, 5, 827, 147);
			contentPanel.add(scrollPane);
			{
				searchResultT = new JTable();
				searchResultT.setBackground(SystemColor.control);
				searchResultT.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int selectRow = searchResultT.getSelectedRow();
						if (selectRow==-1) {
							return;
						}
						String selectId = (String)searchResultT.getModel().getValueAt(selectRow, 0);
						
						for (Flight flight:flightList) {
							if (flight.getFlightName().equals(selectId)) {
								try {
									feeTF.setText(calculateFee(flight.getFee())+"원");
									setFee(calculateFee(flight.getFee()));
									reserveFlightName = selectId;
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							
						}
						
					}
				});
				
				searchResultT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				searchResultT.setFont(new Font("맑은 고딕", Font.BOLD, 17));
				searchResultT.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
					},
					new String[] {
						"\uD56D\uACF5\uD3B8", "\uD56D\uACF5\uC0AC", "\uCD9C\uBC1C\uC77C\uC2DC", "\uCD9C\uBC1C\uC9C0", "\uB3C4\uCC29\uC77C\uC2DC", "\uB3C4\uCC29\uC9C0"
					}
				));
				scrollPane.setViewportView(searchResultT);
				
				
			}
		}
		
		seatRatingTF = new JTextField();
		seatRatingTF.setEditable(false);
		seatRatingTF.setBackground(SystemColor.control);
		seatRatingTF.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		seatRatingTF.setBounds(375, 199, 137, 33);
		contentPanel.add(seatRatingTF);
		seatRatingTF.setColumns(10);
		
		feeTF = new JTextField();
		feeTF.setEditable(false);
		feeTF.setBackground(SystemColor.control);
		feeTF.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		feeTF.setBounds(633, 198, 160, 34);
		contentPanel.add(feeTF);
		feeTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("승객");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(38, 198, 52, 38);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("좌석등급");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_1.setBounds(285, 201, 91, 28);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("요금");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_2.setBounds(586, 198, 52, 33);
		contentPanel.add(lblNewLabel_2);
		
		PassengerTypeTA = new JTextArea();
		PassengerTypeTA.setEditable(false);
		PassengerTypeTA.setBackground(SystemColor.control);
		PassengerTypeTA.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		PassengerTypeTA.setBounds(89, 195, 137, 90);
		contentPanel.add(PassengerTypeTA);
		
		JLabel lblNewLabel_3 = new JLabel("원하시는 항공편을 선택 후 예약하세요.");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3.setBounds(5, 153, 351, 18);
		contentPanel.add(lblNewLabel_3);
		
		reserveCheck = new JRadioButton("상기의 내역을 확인 후 예약에 동의합니다.");
		reserveCheck.setBackground(Color.WHITE);
		reserveCheck.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		reserveCheck.setBounds(519, 296, 313, 27);
		contentPanel.add(reserveCheck);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton reserveB = new JButton("예약");
				reserveB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (reserveCheck.isSelected() && reserveFlightName!=null) {
							Flight reserveFlight = new Flight();
							for (Flight flight : flightList) {
								if (flight.getFlightName().equals(reserveFlightName)) {
									reserveFlight = flight;
								}
							}
							
						try {
							
						Passenger addPassenger = passengerService.findByName(flightReservationMainFrame.loginPassenger.getMemberId());
					
						reservationService.addReservation(new Reservation(seatRating, adultCount, childCount, reserveFlight,addPassenger,fee));
						JOptionPane.showMessageDialog(null, "예약이 완료 되었습니다."+"\n"+"예매내역을 확인하세요");
						
						flightReservationMainFrame.changePanel("reservationFindP");
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						
						dispose();
					
						}else {
							JOptionPane.showMessageDialog(null, "원하시는 항공편을 선택하시고 약관에 동의 후 예약하세요");
						
						}
						System.out.println(seatRating);
						System.out.println(adultCount);
						System.out.println(childCount);
						try {
							System.out.println(reservationService.findByAll());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				reserveB.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				reserveB.setActionCommand("OK");
				buttonPane.add(reserveB);
				getRootPane().setDefaultButton(reserveB);
			}
			{
				JButton cancelB = new JButton("취소");
				cancelB.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				cancelB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelB.setActionCommand("Cancel");
				buttonPane.add(cancelB);
			}
		}
		
		reservationPanel = new ReservationPanel();
		reservationService = new ReservationService();
		passengerService=new PassengerService();
		
	}
/************************************************************************************************/
	
	public ArrayList<Flight> getFlightList() {
		return flightList;
	}
	public void setFlightList(ArrayList<Flight> flightList) throws Exception {
		this.flightList = flightList;
		this.getMemberList();
	}
	public int getAdultCount() {
		return adultCount;
	}
	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
		
	}
	public int getChildCount() {
		return childCount;
	}
	public void setChildCount(int childCount) {
		this.childCount = childCount;
		PassengerTypeTA.setText("성인 : "+adultCount+"명\n"+"소아 : "+childCount+"명\n"+"총 인원 : "+(adultCount+childCount)+"명\n");
	}
	public String getSeatRating() {
		return seatRating;
	}
	public void setSeatRating(String seatRating) {
		this.seatRating = seatRating;
		seatRatingTF.setText(seatRating);
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	/********************************************************/
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	
	/*
	 * 요금 계산
	 */
	
	public double calculateFee(double fee) throws Exception {
		double calFee = 0; // 리턴값
		// 1. 성인요금
		double adultFee = fee * adultCount;
		// 1-2. 유아요금
		double childFee = fee * childCount * 0.9;
		// 1.3 기본 합계 요금
		calFee = adultFee + childFee;
		if (seatRating.equals("비즈니스")) {
			// 2. 비즈니스 요금
			calFee = (adultFee + childFee) * 1.3;
		}
		return calFee;
	}
	
	
	protected void getMemberList() throws Exception {
		ArrayList<Flight> flightList = getFlightList();
		
		//DefaultListModel listModel = new DefaultListModel();
		
		//DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
		
		DefaultTableModel tableModel = new DefaultTableModel();
		Vector columnVector = new Vector();
		
		columnVector.add("항공편");
		columnVector.add("항공사");
		columnVector.add("출발일시");
		columnVector.add("출발지");
		columnVector.add("도착일시");
		columnVector.add("도착지");
		
		tableModel.setColumnIdentifiers(columnVector);
		
		for (Flight flight : flightList) {
			//listModel.addElement(flight.getFlightName());
			//comboBoxModel.addElement(flight.getFlightName());			
			
			Vector rowVector = new Vector();
			
			rowVector.add(flight.getFlightName());
			rowVector.add(flight.getAirlineName());
			rowVector.add(flight.getFlightStartYear()+"/"+flight.getFlightStartMonth()+"/"+flight.getFlightStartDay()+"-"+flight.getFlightStartTime());
			rowVector.add(flight.getStartPoint());
			rowVector.add(flight.getFlightFinishYear()+"/"+flight.getFlightFinishMonth()+"/"+flight.getFlightFinishDay()+"-"+flight.getFlightFinishTime());
			rowVector.add(flight.getFinishPoint());
			
			tableModel.addRow(rowVector);
			
			
			
		}
		
			
		searchResultT.setModel(tableModel);
		//System.out.println(adultCount);
		//System.out.println(this.seatRating);
	}
	public void setMainFrame(FlightReservationMainFrame flightReservationMainFrame) {
		this.flightReservationMainFrame = flightReservationMainFrame;
	}
	
}
	


