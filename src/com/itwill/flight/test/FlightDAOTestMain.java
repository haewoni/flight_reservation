package com.itwill.flight.test;

import com.itwill.flight.Flight;
import com.itwill.flight.FlightDAO;

public class FlightDAOTestMain {
	public static void main(String[] args, Object flight) throws Exception{
		FlightDAO flightDAO = new FlightDAO();
		/*
		System.out.println("------------create----------------");
		boolean isAdd = flightDAO.create(new Flight("id-1", 2020, 07, 20, "07:30", 2020, 07, 20, "12:00", "인천", "다낭", 2500000));
		System.out.println(isAdd);
		isAdd = flightDAO.create(new Flight("id-2", 2020, 07, 22, "09:30", 2020, 07, 22, "14:00", "인천", "하노이", 2400000));
		System.out.println(isAdd);
		
		*/
		
		
		
		
		System.out.println("---------------------readAll------------------------");
		System.out.println(flightDAO.readAll());
		System.out.println("---------------------readOne------------------------");
		System.out.println(flightDAO.readOne("id-1"));
		System.out.println("---------------------update------------------------");
		
		Flight updateFlight = flightDAO.readOne("id-1");
		
		
		updateFlight.setFlightFinishTime("19:30");
		updateFlight.setFlightFinishYear(2021);
		updateFlight.setFlightFinishMonth(05);
		updateFlight.setFlightFinishDay(21);
		updateFlight.setFlightStartTime("06:10");
		updateFlight.setFlightStartYear(2019);
		updateFlight.setFlightStartMonth(06);
		updateFlight.setFlightStartDay(17);
		
		
		updateFlight.setFlightStartTime("09:40");
		updateFlight.setFlightFinishTime("14:10");
		
		flightDAO.update(updateFlight);
		System.out.println(flightDAO.readOne("id-1"));
		System.out.println("---------------------delete------------------------");
		flightDAO.delete("id-1");
		System.out.println(flightDAO.readAll());
		
		
	}
}
