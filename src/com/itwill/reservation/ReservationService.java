package com.itwill.reservation;

import java.util.ArrayList;

import com.itwill.flight.Flight;
import com.itwill.flight.FlightDAO;
import com.itwill.passenger.Passenger;

public class ReservationService {

	private ReservationDAO reservationDAO;
	private FlightDAO flightDAO;
	
	public ReservationService() throws Exception{
		reservationDAO = new ReservationDAO();
		flightDAO = new FlightDAO();
	}
	
	/*
	 * 예약정보 Add
	 */
	
	public void addReservation(Reservation addReservation) throws Exception {
		
		reservationDAO.create(addReservation);		
	}
	
	/*
	 * 예약취소
	 */
	public void remove(int reservationNo) throws Exception {
		reservationDAO.delete(reservationNo);
	}
	

	/*
	 * 예약정보 Update
	 */

	public void updateReservation(Reservation updateReservation) throws Exception {
		reservationDAO.update(updateReservation);
 }
	
	/*
	 * 예약정보 전체 검색()
	 */
	public ArrayList<Reservation> findByAll() throws Exception {
		ArrayList<Reservation> reservationList = reservationDAO.readAll();
		return reservationList;
	}
	/*
	 * 예약번호로 찾기
	 */
	public Reservation findByNo(int no) throws Exception{
		ArrayList<Reservation> reservationList = reservationDAO.readAll();
		Reservation findReservation = new Reservation();
		for (Reservation reservation : reservationList) {
			if (reservation.getReservationNo()==no) {
				findReservation = reservation;
			}
		}
		return findReservation;
	}
	
	/*
	 * 항공편 검색 (편도)
	 */

	public ArrayList<Flight> readOneWay(String finishPoint, int flightStartMonth, int flightStartDay) throws Exception{     //????????test 필수
		ArrayList<Flight> flightList = flightDAO.readFile();
		ArrayList<Flight> temp = new ArrayList<Flight>();
		for (Flight flight : flightList) {
			if (flight.getFinishPoint().equals(finishPoint) && 
					((flight.getFlightStartMonth() >= flightStartMonth && 
					flight.getFlightStartDay() >= flightStartDay)||flight.getFlightStartMonth()>flightStartMonth)) {
					temp.add(flight);
			}
		}
		return temp;
	}
	/*
	 * 왕복고잉
	 */
	public ArrayList<Flight> readRoundGoing(String finishPoint, int flightStartMonth, int flightStartDay, int flightComingMonth, int flightComingDay) throws Exception{     //????????test 필수
		ArrayList<Flight> flightList = flightDAO.readFile();
		ArrayList<Flight> temp = new ArrayList<Flight>();
		for (Flight flight : flightList) {
			if (flight.getFinishPoint().equals(finishPoint) && 
				((flight.getFlightStartMonth() == flightStartMonth && 
				flight.getFlightStartDay() >= flightStartDay || flight.getFlightStartMonth()>flightStartMonth)) &&
				flight.getFlightStartMonth() <= flightComingMonth &&
				flight.getFlightStartDay() < flightComingDay) {
				temp.add(flight);
			}
		}
		return temp;
	}
	
	
	/*
	 * 항공편 검색 (왕복커밍)
	 */
	
	public ArrayList<Flight> readRoundTrip(String startPoint, String finishPoint, int flightStartMonth, int flightStartDay, int flightComingMonth, int flightComingDay) throws Exception{     //????????test 필수
		ArrayList<Flight> flightList = flightDAO.readFile();
		ArrayList<Flight> temp = new ArrayList<Flight>();
		for (Flight flight : flightList) {
			if (flight.getFinishPoint().equals("인천") && 
				flight.getStartPoint().equals(startPoint)&&
				((flight.getFlightStartMonth() >= flightStartMonth && 
				flight.getFlightStartDay() >= flightStartDay)||flight.getFlightStartMonth()>flightStartMonth)) {
				temp.add(flight);
			}
		}
		return temp;
	}

	public ArrayList<Reservation> findById(String memberId) throws Exception {
		ArrayList<Reservation> reservationList = reservationDAO.readFile();
		ArrayList<Reservation> findReservationList = new ArrayList<Reservation>();
		for (Reservation reservation : reservationList) {
			if (reservation.getPassenger().getMemberId().equals(memberId)) {
				findReservationList.add(reservation);
			}
		}
		return findReservationList;
	}
	
	
	


	

}
