package com.itwill.reservation.test;

import com.itwill.flight.Flight;
import com.itwill.passenger.Passenger;
import com.itwill.reservation.Reservation;
import com.itwill.reservation.ReservationService;

public class ReservationServiceTestMain {
	public static void main(String[] args) throws Exception {
		ReservationService reservationService = new ReservationService();
		Flight flight1 = new Flight("OZ101", 2020, 7, 25, "8:00", 2020, 7, 25, "13:30", "인천", "다낭", 5000000, "아시아나");
		//Flight flight2 = new Flight("OZ101", 2020, 8, 25, "8:00", 2020, 8, 25, "13:30", "다낭", "인천", 5000000, "아시아나");
		
		Flight flight2 = new Flight("KE302", 2020, 8, 5, "12:00", 2020, 8, 6, "2:00", "인천", "런던", 1100000, "대한항공");
		Flight flight3 = new Flight("NZ544", 2020, 8, 10, "1:00", 2020, 8, 10, "7:00", "인천", "뉴욕", 1900000, "자바항공");
		Flight flight4 = new Flight("ZE880", 2020, 9, 30, "11:20", 2020, 10, 1, "11:30", "인천", "런던", 4300000,"자바항공");
		
		
		Passenger passenger1 = new Passenger("xxx", "xxx", "김구달", "470123", "010-3333-4444");
		
		Passenger passenger2 = new Passenger("yyy", "yyy", "왕준식", "860723", "010-5555-6666");
		Passenger passenger3 = new Passenger("zzz", "zzz", "박말자", "660223", "010-7777-8888");
		Passenger passenger4 = new Passenger("aaa", "aaa", "신혜원", "960305", "010-1234-5678");
		
		
		
		/*
		 * 예약정보 Add
		 */
		
		reservationService.addReservation(new Reservation("비즈니스", 2, 0, flight1, passenger1));
		reservationService.addReservation(new Reservation("이코노미", 2, 2, flight2, passenger2));
		reservationService.addReservation(new Reservation("비즈니스", 1, 0, flight3, passenger3));
		reservationService.addReservation(new Reservation("이코노미", 4, 4, flight4, passenger4));
		
		
		//reservationService.addReservation(new Reservation("이코노미", 1, 0, flight1, passenger1));
		//reservationService.addReservation(new Reservation("이코노미", 1, 0, flight2, passenger1));
		
		
		System.out.println(reservationService.findByAll());
		
		
		
		
		
		
		
		
		/*
		 * 예약취소 
		 */
		//reservationService.remove(1000);
	
		
		/*
		 * 예약정보 Update
		 */
	
		
	}
}
