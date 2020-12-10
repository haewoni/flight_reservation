package com.itwill.passenger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PassengerDAO {
	private File passengerFile;

	public PassengerDAO() throws Exception {
		passengerFile = new File("passenger.ser");
		if (!passengerFile.exists()) {
			System.out.println("파일생성[passenger.ser]");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(passengerFile));
			oos.writeObject(new ArrayList<Passenger>());
		}
	}

	/**********************************************/
	private ArrayList<Passenger> readFile() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(passengerFile));
		ArrayList<Passenger> passengerList = (ArrayList<Passenger>) ois.readObject();
		ois.close();
		return passengerList;
	}

	private void writeFile(ArrayList<Passenger> passengerList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(passengerFile));
		oos.writeObject(passengerList);
		oos.close();
	}
	/*
	 * create
	 */ 
	public boolean create(Passenger addPassenger) throws Exception {
		boolean isSuccess = false;
		ArrayList<Passenger> passengerList = readFile();
		if (isDuplicateId(addPassenger.getMemberId())) {
			isSuccess = false;
			return isSuccess;
		}
		isSuccess = true;
		passengerList.add(addPassenger);
		writeFile(passengerList);
		return isSuccess;
	}
	public boolean isDuplicateId(String memberId) throws Exception {
		boolean isDuplicate = false;
		ArrayList<Passenger> passengerList = readFile();
		for (Passenger passenger : passengerList) {
			if (passenger.getMemberId().equals(memberId)) {
				isDuplicate = true;
				break;
			}
		}
		return isDuplicate;
	}
	/*
	 * readAll
	 */
	public ArrayList<Passenger> readAll() throws Exception {
		return readFile();
	}
	/*
	 * readOne
	 */
	public Passenger readOne(String memberId) throws Exception {
		Passenger findPassenger = null;
		ArrayList<Passenger> passengerList = readFile();
		for (Passenger passenger : passengerList) {
			if (passenger.getMemberId().equals(memberId)) {
				findPassenger = passenger;
				break;
			}
		}
		
		
		return findPassenger;
	}
	/*
	 * update
	 */
	public void update(Passenger updatePassenger) throws Exception {
		ArrayList<Passenger> passengerList = this.readFile();
		for (Passenger passenger : passengerList) {
			if(passenger.getMemberId().equals(updatePassenger.getMemberId())) {
				passenger.setMemberName(updatePassenger.getMemberName());
				passenger.setMemberPw(updatePassenger.getMemberPw());
				passenger.setBirthDate(updatePassenger.getBirthDate());
				passenger.setPhoneNo(updatePassenger.getPhoneNo());
			
				
				break;
			}
		}
		writeFile(passengerList);
		}
	/*
	 * delete
	 */
	public void delete(String memberId) throws Exception {
		ArrayList<Passenger> passengerList = this.readFile();
		for (Passenger passenger : passengerList) {
			if (passenger.getMemberId().equals(memberId)) {
				passengerList.remove(passenger);
				break;
			}
		}
		writeFile(passengerList);
		
	
	}
}
