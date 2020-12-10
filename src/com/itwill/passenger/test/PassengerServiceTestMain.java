package com.itwill.passenger.test;

import com.itwill.passenger.Passenger;
import com.itwill.passenger.PassengerService;

public class PassengerServiceTestMain {
	public static void main(String[] args) throws Exception {
			PassengerService passengerService = new PassengerService();
			/*
			 * register
			 */
			System.out.println("----register----");
			boolean isSuccess = passengerService.passengerRegister(new Passenger("vvv", "vvv", "이희수", "890123", "010-2030-4050"));
			System.out.println(isSuccess);
			isSuccess = passengerService.passengerRegister(new Passenger("yyy", "yyy", "김연아", "901213", "010-3928-2037"));
			System.out.println(isSuccess);
			isSuccess = passengerService.passengerRegister(new Passenger("zzz", "zzz", "최유정", "910317", "010-6327-0646"));
			System.out.println(isSuccess);
			/*
			 * login
			 */
			System.out.println("----login----");
			int loginResult=passengerService.login("vvv","vvv");
			System.out.println(loginResult);
			loginResult=passengerService.login("yyy","aaa");
			System.out.println(loginResult);
			loginResult=passengerService.login("bbb","zzz");
			System.out.println(loginResult);
			/*
			 * update
			 */
			System.out.println("----update--");
			Passenger updatePassenger = new Passenger("vvv", "fff", "이수혁", "771021", "010-2224-9268");
			passengerService.memberUpdate(updatePassenger);
			
			/*
			 * delete
			 */
			passengerService.memberDelete("zzz");
			
			System.out.println(passengerService.findByAll());
			
		
	
	}
}