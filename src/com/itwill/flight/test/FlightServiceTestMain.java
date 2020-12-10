package com.itwill.flight.test;

import java.util.ArrayList;

import com.itwill.flight.Flight;
import com.itwill.flight.FlightService;

public class FlightServiceTestMain {
	public static void main(String[] args) throws Exception {
		
		FlightService fs = new FlightService();
		/*
		 * 추가
		 */
		System.out.println("------------add----------------");
		boolean isAdd = fs.addFlight(new Flight("OZ101", 2020, 7, 25, "8:00", 2020, 7, 25, "13:30", "인천", "다낭", 5000000, "아시아나"));
		System.out.println(isAdd);
		isAdd = fs.addFlight(new Flight("KE302", 2020, 8, 5, "12:00", 2020, 8, 6, "2:00", "인천", "런던", 1100000, "대한항공"));
		System.out.println(isAdd);
		isAdd = fs.addFlight(new Flight("NZ544", 2020, 8, 10, "1:00", 2020, 8, 10, "7:00", "인천", "뉴욕", 1100000, "자바항공"));
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
		
		
		
		
		
		
	}
}
