package com.itwill.reservation.test;

import com.itwill.flight.Flight;
import com.itwill.passenger.Passenger;
import com.itwill.reservation.Reservation;
import com.itwill.reservation.ReservationDAO;

public class ReservationDAOTestMain {
	public static void main(String[] args) throws Exception {
		ReservationDAO reservationDAO = new ReservationDAO();

         
		Flight flight1 = new Flight("OZ101", 2020, 7, 25, "8:00", 2020, 7, 25, "13:30", "인천", "다낭", 5000000, "아시아나");
		Flight flight2 = new Flight("KE302", 2020, 8, 5, "12:00", 2020, 8, 6, "2:00", "인천", "런던", 1100000, "대한항공");
		Flight flight3 = new Flight("NZ544", 2020, 8, 10, "1:00", 2020, 8, 10, "7:00", "인천", "뉴욕", 1100000, "자바항공");
		Flight flight4 = new Flight("ZE880", 2020, 9, 30, "11:20", 2020, 10, 1, "11:30", "인천", "런던", 4300000,"자바항공");
		
		Passenger passenger1 = new Passenger("xxx", "xxx", "김구달", "470123", "010-3333-4444");
		Passenger passenger2 = new Passenger("yyy", "yyy", "왕준식", "860723", "010-5555-6666");
		Passenger passenger3 = new Passenger("zzz", "zzz", "박말자", "660223", "010-7777-8888");
		Passenger passenger4 = new Passenger("aaa", "aaa", "신혜원", "960305", "010-1234-5678");
		
		
		System.out.println("--------------------- create ------------------------");
		boolean isSuccess = reservationDAO.create(new Reservation("이코노미", 1, 1, flight1, passenger1));
		System.out.println(isSuccess);
		isSuccess = reservationDAO.create(new Reservation("비지니스", 4, 20, flight2, passenger2));
		System.out.println(isSuccess);
		isSuccess = reservationDAO.create(new Reservation("이코노미", 2, 0, flight3, passenger3));
		System.out.println(isSuccess);
		isSuccess = reservationDAO.create(new Reservation("이코노미", 2, 0, flight4, passenger4));
		System.out.println(isSuccess);
		
		
		System.out.println("--------------------- readAll ------------------------");
		System.out.println(reservationDAO.readAll());
		System.out.println();

		System.out.println("--------------------- readOne ------------------------");
		System.out.println(reservationDAO.readOne(1002));
		
		System.out.println("--------------------- update ------------------------");
		Reservation updateReservation = new Reservation(1000, "비즈니스",1, 1, flight4);
		reservationDAO.update(updateReservation);
		System.out.println(reservationDAO.readAll());
		
		System.out.println("--------------------- delete ------------------------");
		reservationDAO.delete(1002);
		System.out.println(reservationDAO.readAll());
		
		
		
		
	}
}
