package com.itwill.flight;

import java.util.ArrayList;

import com.itwill.passenger.Passenger;

public class FlightService {

	private FlightDAO flightDAO;
	public FlightService() throws Exception {
		flightDAO = new FlightDAO();
	}
	/*
	 * 추가
	 */
	public boolean addFlight(Flight addFlight) throws Exception {
		boolean isSuccess = false;
		isSuccess = flightDAO.create(addFlight);
		return isSuccess;
	}
	/*
	 * readAll
	 */
	public ArrayList<Flight> findAllFlight() throws Exception {
		return flightDAO.readAll();
	}
	
	/*
	 * readByFlightName
	 */
	public Flight findByName(String flightName) throws Exception{
		return flightDAO.readOne(flightName);
	}
	
	/*
	 * 수정
	 */
	public void updateFlight(Flight updateFlight) throws Exception {
		flightDAO.update(updateFlight);
	}
	
	/*
	 * 삭제
	 */
	public void deleteFlight(String flightName) throws Exception {    
		flightDAO.delete(flightName);
	}
	
}
