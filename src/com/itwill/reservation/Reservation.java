package com.itwill.reservation;

import java.io.Serializable;


import com.itwill.flight.Flight;
import com.itwill.passenger.Passenger;

public class Reservation implements Serializable {

	private int reservationNo; // 예약번호
	private String seatRating; // 좌석등급
	private int adultCount; // 성인 수
	private int childCount; // 유아 수
	private int count; // 승객
	private Flight flight; // 포함
	private Passenger passenger; // 포함
	private static int inherenceReserveNo = 1000; // 예약번호 생성
	
	private double fee;
	

	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	public void findReservationData() {
		
	}
	/*
	 * Update용 생성자 -- 예약번호 인자
	 */
	public Reservation(int reservationNo, String seatRating, int adultCount, int childCount, Flight flight) {
		super();
		this.reservationNo = reservationNo;
		this.seatRating = seatRating;
		this.adultCount = adultCount;
		this.childCount = childCount;		
		this.flight = flight;
	}

	public Reservation(String seatRating, int adultCount, int childCount, Flight flight, Passenger passenger) {
		super();
		this.seatRating = seatRating;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.count = adultCount + childCount;
		this.reservationNo = generateNo();
		this.flight = flight;
		this.passenger = passenger;
	}
	public Reservation(String seatRating, int adultCount, int childCount, Flight flight, Passenger passenger, double fee) {
		super();
		this.seatRating = seatRating;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.count = adultCount + childCount;
		this.reservationNo = generateNo();
		this.flight = flight;
		this.passenger = passenger;
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Reservation [reservationNo=" + reservationNo + ", seatRating=" + seatRating + ", adultCount="
				+ adultCount + ", childCount=" + childCount + ", count=" + count + ", flight=" + flight + ", passenger="
				+ passenger + "]" + "\n";
	}

	public int generateNo() {
		int reservationNo = inherenceReserveNo++;
		return reservationNo;
	}

	public static int getInherenceReserveNo() {
		return inherenceReserveNo;
	}

	public static void setInherenceReserveNo(int inherenceReserveNo) {
		Reservation.inherenceReserveNo = inherenceReserveNo;
	}

	public String getSeatRating() {
		return seatRating;
	}

	public void setSeatRating(String seatRating) {
		this.seatRating = seatRating;
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
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public double getReservationFee() {
		return fee;
	}
	public void setReservationFee(int fee) {
		this.fee = fee;
	}

}
