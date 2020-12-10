package com.itwill.flight;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FlightDAO {

	public File flightFile;

	
	public FlightDAO() throws Exception{
		/*********************************************/
		flightFile = new File("flights.ser");
		if (!flightFile.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(flightFile));
			
			
			oos.writeObject(new ArrayList<Flight>());
			oos.close();
		}
		
	}
		
		/*********************************************/
		
	public ArrayList<Flight> readFile() throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(flightFile));
		ArrayList<Flight> flightList = (ArrayList<Flight>)ois.readObject();
		ois.close();
		return flightList;
	}
		
	private void writeFile(ArrayList<Flight> flightList) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(flightFile));
		oos.writeObject(flightList);
		oos.close();
	
	
	}
	
	/*
	 * create
	 */
	public boolean create(Flight addFlight) throws Exception{
		boolean isSuccess = false;
		ArrayList<Flight> flightList = this.readFile();
		if (isDuplicateName(addFlight.getFlightName())) {
			isSuccess = false;
			return isSuccess;
		}
		isSuccess = true;
		flightList.add(addFlight);
		this.writeFile(flightList);
		return isSuccess;
		
	}
	
	public boolean isDuplicateName(String flightName) throws Exception{
		boolean isDuplicate = false;
		ArrayList<Flight> flightList = this.readFile();
		for (Flight flight : flightList) {
			if (flight.getFlightName().equals(flightName)) {
				isDuplicate = true;
				break;
			}
		}
		return isDuplicate;
	}
	/*
	 * readAll
	 */
	
	public ArrayList<Flight> readAll() throws Exception{
		return this.readFile();
	}
	/*
	 * readOne
	 */
	 
	
	public Flight readOne(String flightName) throws Exception{
		Flight findFlight = null;
		ArrayList<Flight> flightList = this.readFile();
		for (Flight flight : flightList) {
			if (flight.getFlightName().equals(flightName)) {
				findFlight = flight;
				break;
			}
		}
		return findFlight;
	}
	
	
	/*
	 * update
	 */	
	public void update(Flight updateFlight) throws Exception {
		ArrayList<Flight> flightList = readFile();
		for (Flight flight : flightList) {
			if (flight.getFlightName().equals(updateFlight.getFlightName())) {
				flight.setFlightFinishTime(updateFlight.getFlightFinishTime());
				flight.setFlightFinishYear(updateFlight.getFlightFinishYear());
				flight.setFlightFinishMonth(updateFlight.getFlightFinishMonth());
				flight.setFlightFinishDay(updateFlight.getFlightFinishDay());
				flight.setFlightStartTime(updateFlight.getFlightStartTime());
				flight.setFlightStartYear(updateFlight.getFlightStartYear());
				flight.setFlightStartMonth(updateFlight.getFlightStartMonth());
				flight.setFlightStartDay(updateFlight.getFlightStartDay());
				 
				break;
			}
		}
		writeFile(flightList);
	}
	
	/*
	 * delete
	 */	
	public void delete(String flightName) throws Exception{
		ArrayList<Flight> flightList = this.readFile();
		for (Flight flight : flightList) {
			if (flight.getFlightName().equals(flightName)) {
				flightList.remove(flight);
				break;
			}
		}
		this.writeFile(flightList);
	}
	
}
