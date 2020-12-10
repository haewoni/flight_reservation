package com.itwill.UI.reservation; //예매

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.jdatepicker.JDatePicker;

import com.itwill.UI.main.FlightReservationMainFrame;
import com.itwill.flight.Flight;
import com.itwill.reservation.ReservationService;


public class ReservationPanel extends JPanel {
	private JComboBox finishPointCB;
	private JDatePicker startDayDP;
	private JDatePicker comingDayDP;
	private JComboBox seatRatingCB;
	String loginId = "";
	/**
	 * @wbp.nonvisual location=28,134
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel passengerTypePanel;
	private JSpinner adultCountSP;
	private JSpinner childCountSP;
	private JButton PassengerTypeB;

	/************************************************************************/

	ReservationService reservationService;
	FlightReservationMainFrame flightReservationMainFrame;
	
	/************************************************************************/

	/**
	 * Create the panel.
	 */
	public ReservationPanel() {
		
		setLayout(new BorderLayout(0, 0));
	
		JPanel reservAirPanel = new JPanel();
		reservAirPanel.setBackground(Color.WHITE);
		add(reservAirPanel, BorderLayout.CENTER);
		reservAirPanel.setLayout(null);

		passengerTypePanel = new JPanel();
		passengerTypePanel.setVisible(false);

		JLabel lblNewLabel_4 = new JLabel("오는날 선택");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_4.setBounds(332, 198, 219, 21);
		reservAirPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("가는날 선택");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3.setBounds(118, 198, 112, 21);
		reservAirPanel.add(lblNewLabel_3);
		passengerTypePanel.setBackground(SystemColor.menu);
		passengerTypePanel.setLayout(null);
		passengerTypePanel.setBounds(118, 301, 175, 87);
		reservAirPanel.add(passengerTypePanel);

		JLabel lblNewLabel = new JLabel("성인");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(35, 12, 62, 25);
		passengerTypePanel.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("소아");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(35, 45, 62, 32);
		passengerTypePanel.add(lblNewLabel_1_1);

		adultCountSP = new JSpinner();
		adultCountSP.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		adultCountSP.setBounds(80, 13, 50, 24);
		passengerTypePanel.add(adultCountSP);

		childCountSP = new JSpinner();
		childCountSP.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		childCountSP.setBounds(80, 49, 50, 24);
		passengerTypePanel.add(childCountSP);

		finishPointCB = new JComboBox();
		finishPointCB.setToolTipText("");
		finishPointCB.setBackground(Color.WHITE);
		finishPointCB.setModel(new DefaultComboBoxModel(new String[] {"목적지", "다낭", "파리", "런던", "마드리드", "뉴욕"}));
		finishPointCB.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		finishPointCB.setBounds(366, 101, 185, 67);
		reservAirPanel.add(finishPointCB);

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		textPane.setText("인천");
		textPane.setEditable(false);
		textPane.setBounds(171, 101, 112, 80);
		reservAirPanel.add(textPane);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		// ImageIcon객체를 생성
		String imgPath = "C:\\Users\\STU-09\\Downloads\\pngwing.com.png";
		ImageIcon originIcon = new ImageIcon(imgPath);
		// ImageIcon에서 Image를 추출
		java.awt.Image originImg = originIcon.getImage();
		// 추출된 Image의 크기를 조절하여 새로운 Image객체 생성
		Image changedImg = originImg.getScaledInstance(40, 38, Image.SCALE_SMOOTH);
		// 새로운 Image로 ImageIcon객체를 생성
		ImageIcon Icon = new ImageIcon(changedImg);
		lblNewLabel_1.setIcon(Icon);
		lblNewLabel_1.setBounds(284, 119, 60, 38);
		reservAirPanel.add(lblNewLabel_1);

		startDayDP = new JDatePicker();
		startDayDP.setToolTipText("");
		startDayDP.setBounds(118, 219, 175, 27);
		reservAirPanel.add(startDayDP);

		comingDayDP = new JDatePicker();
		comingDayDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comingDayDP.setBounds(332, 219, 175, 27);
		reservAirPanel.add(comingDayDP);

		seatRatingCB = new JComboBox();
		seatRatingCB.setModel(new DefaultComboBoxModel(new String[] { "이코노미", "비즈니스" }));
		seatRatingCB.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		seatRatingCB.setBounds(332, 271, 175, 27);
		reservAirPanel.add(seatRatingCB);

		JRadioButton oneWayRB = new JRadioButton("편도");
		oneWayRB.setBackground(Color.WHITE);
		oneWayRB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		oneWayRB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int state = e.getStateChange();
				if (state == ItemEvent.SELECTED) {
					comingDayDP.setEnabled(false);
				}
			}
		});

		oneWayRB.setBounds(25, 39, 60, 27);
		reservAirPanel.add(oneWayRB);

		JRadioButton roundTripRB = new JRadioButton("왕복");
		roundTripRB.setBackground(Color.WHITE);
		roundTripRB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		roundTripRB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int state = e.getStateChange();
				if (state == ItemEvent.SELECTED) {
					comingDayDP.setEnabled(true);
				}
			}
		});
		oneWayRB.setSelected(true);
		roundTripRB.setBounds(91, 36, 66, 32);
		reservAirPanel.add(roundTripRB);
		buttonGroup.add(roundTripRB);
		buttonGroup.add(oneWayRB);

		PassengerTypeB = new JButton("탑승객 선택");
		PassengerTypeB.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		PassengerTypeB.addActionListener(new ActionListener() {
			boolean b = true;

			public void actionPerformed(ActionEvent e) {

				passengerTypePanel.setVisible(b);
				b = !b;

			}

		});

		PassengerTypeB.setBounds(118, 275, 175, 27);
		reservAirPanel.add(PassengerTypeB);

		JButton searchB = new JButton("항공권 검색");
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					if (oneWayRB.isSelected() && 
							(String) finishPointCB.getSelectedItem()!=""&&
							(int) adultCountSP.getValue()+(int) childCountSP.getValue()!=0&&
							(String) seatRatingCB.getSelectedItem()	!="") {
						int flightStartMonth = startDayDP.getModel().getMonth() + 1;
						int flightStartday = startDayDP.getModel().getDay();
						String finishPoint = (String) finishPointCB.getSelectedItem();
						int adultCount = (int) adultCountSP.getValue();
						int childCount = (int) childCountSP.getValue();
						String seatRating = (String) seatRatingCB.getSelectedItem();
											
						ArrayList<Flight> flightList = reservationService.readOneWay(finishPoint, flightStartMonth,
								flightStartday);
						OnewayReservationSearchResultDialog dialog=new OnewayReservationSearchResultDialog();
						dialog.setMainFrame(flightReservationMainFrame);
						dialog.setFlightList(flightList);
						dialog.setAdultCount(adultCount);
						dialog.setChildCount(childCount);
						dialog.setSeatRating(seatRating);			
						dialog.setVisible(true);
						
					}else if (roundTripRB.isSelected()&&
								(String) finishPointCB.getSelectedItem()!=""&&
								(int) adultCountSP.getValue()+(int) childCountSP.getValue()!=0&&
								(String) seatRatingCB.getSelectedItem()	!="") {
						int flightStartMonth = startDayDP.getModel().getMonth() + 1;
						int flightStartday = startDayDP.getModel().getDay();
						
						int flightComingMonth = comingDayDP.getModel().getMonth() + 1;
						int flightComingDay = comingDayDP.getModel().getDay();
						
						
						String finishPoint = (String) finishPointCB.getSelectedItem();
						int adultCount = (int) adultCountSP.getValue();
						int childCount = (int) childCountSP.getValue();
						String seatRating = (String) seatRatingCB.getSelectedItem();
												
						ArrayList<Flight> flightList = reservationService.readRoundGoing(finishPoint, flightStartMonth,
								flightStartday, flightComingMonth, flightComingDay);
						RoundTripGoingReservationSearchResultDialog dialog=new RoundTripGoingReservationSearchResultDialog();
						dialog.setMainFrame(flightReservationMainFrame);
						dialog.setFlightList(flightList);
						dialog.setAdultCount(adultCount);
						dialog.setChildCount(childCount);
						dialog.setSeatRating(seatRating);	
						dialog.setFlightComingMonth(flightComingMonth);
						dialog.setFlightComingDay(flightComingDay);
						dialog.setFlightGoingMonth(flightStartMonth);
						dialog.setFlightGoingDay(flightStartday);
						
						
						
						
						dialog.setFinishPoint(finishPoint);
						dialog.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "검색 조건을 입력하세요.");
					}
					
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		searchB.setOpaque(false);
		searchB.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		searchB.setBounds(191, 391, 242, 47);
		reservAirPanel.add(searchB);
		try {
			reservationService = new ReservationService();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}



	public void setModal(boolean b) {
		
		
	}



	
	public void setMainFrame(FlightReservationMainFrame flightReservationMainFrame) {
		this.flightReservationMainFrame = flightReservationMainFrame;
	}


}
