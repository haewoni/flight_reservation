package com.itwill.passenger.test;

import com.itwill.passenger.Passenger;
import com.itwill.passenger.PassengerDAO;

public class PassengerDAOTestMain {
	public static void main(String[] args) throws Exception {
		PassengerDAO passengerDAO = new PassengerDAO();
		System.out.println("------------create----------------");
		boolean isAdd = passengerDAO.create(new Passenger("haewoni", "1234", "신혜원", "1996.03.05", "010-1234-5678"));
		System.out.println(isAdd);
		isAdd = passengerDAO.create(new Passenger("jiwoni", "1234", "신지원", "1993.12.07", "010-1234-5678"));
		System.out.println(isAdd);
		isAdd = passengerDAO.create(new Passenger("woni", "1234", "신워니", "1995.03.05", "010-1234-5678"));
		System.out.println(isAdd);
		System.out.println("---------------------readAll------------------------");
		System.out.println(passengerDAO.readAll());
		System.out.println("---------------------readOne------------------------");
		System.out.println(passengerDAO.readOne("woni"));
		System.out.println("---------------------update------------------------");
		Passenger updatePassenger = passengerDAO.readOne("haewoni");
		updatePassenger.setMemberName("김혜원");
		
		updatePassenger.setBirthDate("1990.03.05");
		updatePassenger.setPhoneNo("010-1234-1234");
		System.out.println(passengerDAO.readOne("haewoni"));
		System.out.println("---------------------delete------------------------");
		passengerDAO.delete("jiwoni");
		System.out.println(passengerDAO.readAll());
	}

}