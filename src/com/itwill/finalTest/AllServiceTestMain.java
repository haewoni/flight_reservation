package com.itwill.finalTest;

import com.itwill.flight.Flight;
import com.itwill.flight.FlightService;
import com.itwill.passenger.Passenger;
import com.itwill.passenger.PassengerService;
import com.itwill.reservation.Reservation;
import com.itwill.reservation.ReservationService;

public class AllServiceTestMain {
	public static void main(String[] args) throws Exception {
		

		System.out.println("************************* 1. Flight Service Test ****************************");
		FlightService fs = new FlightService();
		/*
		 * 추가
		 */
		System.out.println("------------add----------------");
		boolean isAdd = fs
				.addFlight(new Flight("OZ101", 2020, 7, 25, "8:00", 2020, 7, 25, "13:30", "인천", "다낭", 5000000, "아시아나"));
		System.out.println(isAdd);
		isAdd = fs.addFlight(new Flight("KE302", 2020, 8, 5, "12:00", 2020, 8, 6, "2:00", "인천", "런던", 1100000, "대한항공"));
		System.out.println(isAdd);
		isAdd = fs
				.addFlight(new Flight("NZ544", 2020, 8, 10, "1:00", 2020, 8, 10, "7:00", "인천", "뉴욕", 1100000, "자바항공"));
		System.out.println(isAdd);
		/*
		 * 수정
		 */
		System.out.println("------------update----------------");
		fs.updateFlight(new Flight("NZ544", 2020, 8, 11, "3:00", 2020, 8, 11, "10:00", "인천", "뉴욕", 1100000, "자바항공"));
		/*
		 * delete
		 */
		System.out.println("------------delete----------------");
		fs.deleteFlight("OZ101");
		/*
		 * readAll
		 */
		System.out.println("------------readAll----------------");
		System.out.println(fs.findAllFlight());
		System.out.println();
		
		

		
		

		System.out.println("************************** 2. Passenger Service Test ****************************");
		PassengerService passengerService = new PassengerService();
		/*
		 * register
		 */
		System.out.println("----register----");
		boolean isSuccess = passengerService
				.passengerRegister(new Passenger("xxx", "xxx", "이희수", "890123", "010-2030-4050"));
		System.out.println(isSuccess);
		isSuccess = passengerService.passengerRegister(new Passenger("yyy", "yyy", "김연아", "901213", "010-3928-2037"));
		System.out.println(isSuccess);
		isSuccess = passengerService.passengerRegister(new Passenger("zzz", "zzz", "최유정", "910317", "010-6327-0646"));
		System.out.println(isSuccess);
		/*
		 * login
		 */
		System.out.println("----login----");
		int loginResult = passengerService.login("xxx", "xxx");
		System.out.println(loginResult);
		loginResult = passengerService.login("yyy", "aaa");
		System.out.println(loginResult);
		loginResult = passengerService.login("bbb", "zzz");
		System.out.println(loginResult);
		/*
		 * update
		 */
		System.out.println("----update--");
		Passenger updatePassenger = new Passenger("xxx", "aaa", "이수혁", "771021", "010-2224-9268");
		passengerService.memberUpdate(updatePassenger);

		passengerService.memberDelete("zzz");
		System.out.println();



		
		System.out.println("************************** 3. Reservation Service Test****************************");
		ReservationService reservationService = new ReservationService();

		Flight flight1 = new Flight("OZ101", 2020, 7, 25, "8:00", 2020, 7, 25, "13:30", "인천", "다낭", 5000000, "아시아나");
		Flight flight2 = new Flight("KE302", 2020, 8, 5, "12:00", 2020, 8, 6, "2:00", "인천", "런던", 1100000, "대한항공");
		Flight flight3 = new Flight("NZ544", 2020, 8, 10, "1:00", 2020, 8, 10, "7:00", "인천", "뉴욕", 1100000, "자바항공");
		Flight flight4 = new Flight("ZE880", 2020, 9, 30, "11:20", 2020, 10, 1, "11:30", "인천", "런던", 4300000, "자바항공");

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
		/*
		 * 예약취소
		 */
		reservationService.remove(1000);
		/*
		 * 예약정보 Update
		 */
		Reservation reservationService1 = new Reservation(1001, "비즈니스", 2, 2, flight4);
		reservationService.updateReservation(reservationService1);

		System.out.println(reservationService.findByAll());

	}
}
