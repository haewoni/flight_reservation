package com.itwill.passenger;

import java.util.ArrayList;

import com.itwill.reservation.Reservation;

public class PassengerService {

	private PassengerDAO passengerDAO;
	public String memberId;     //public 열어도 되나요
	public String memberPw;
	private String memberName;
	private String birthDate;
	private String phoneNo;

	public PassengerService() throws Exception {
		passengerDAO = new PassengerDAO();
	}

	

	/*
	 * 회원가입
	 */

	public boolean passengerRegister(Passenger addPassenger) throws Exception {
		boolean isSuccess = false;
		isSuccess = passengerDAO.create(addPassenger);
		return isSuccess;
	}

	/*
	 * 로그인
	 */
	public int login(String memberId, String memberPw) throws Exception {
		int result = -99;
		/*
		 * 0 : 성공 1 : 아이디 존재안함 2 : 비번틀림
		 */
		if (passengerDAO.isDuplicateId(memberId)) {
			Passenger findPassenger = passengerDAO.readOne(memberId);
			if (findPassenger.matchPassword(memberPw)) {
				result = 0;
			} else {
				result = 2;
			}
		} else {
			result = 1;
		}
		return result;
	}
	/*
	 * 승객 한 명 검색
	 */
	public Passenger findById(String memberId) throws Exception {
		return passengerDAO.readOne(memberId);
		
	}
	/*
	 * 승객 전체 검색()
	 */
	public ArrayList<Passenger> findByAll() throws Exception {
		ArrayList<Passenger> passengerList = passengerDAO.readAll();
		return passengerList;
	}
	/*
	 * 승객 전체 검색()
	 */
	public Passenger findByName(String findMemberId) throws Exception{
		ArrayList<Passenger> passengerList = passengerDAO.readAll();
		Passenger findPassenger = new Passenger();
		for (Passenger passenger : passengerList) {
			if (passenger.getMemberId().equals(findMemberId)) {
				findPassenger = passenger;
			}
		}
		return findPassenger;
	}

	// 승객 업데이트
	public void memberUpdate(Passenger updatePassenger) throws Exception {
		passengerDAO.update(updatePassenger);
	}

	// 승객 삭제
	public void memberDelete(String memberId) throws Exception {
		passengerDAO.delete(memberId);

	}
}
