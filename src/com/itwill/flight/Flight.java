package com.itwill.flight;

import java.io.Serializable;

public class Flight implements Serializable {

	private String flightName;       // 비행편
	private int flightStartYear;     // 출발 년도(Year)
	private int flightStartMonth;    // 출발 월(Month)
	private int flightStartDay;      // 출발 날(day)
	private String flightStartTime;  // 출발 시간
	private int flightFinishYear;    // 도착 년도(Year)
	private int flightFinishMonth;   // 도착 월(Month)
	private int flightFinishDay;     // 도착날(day)
	private String flightFinishTime; // 도착시간
	private String startPoint;       // 출발지
	
	


	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}


	private String finishPoint;      // 도착지
	private int fee;	//기본요금
	private String airlineName;		//항공회사 이름


	public Flight() {
		// TODO Auto-generated constructor stub
	}


	public Flight(String flightName, int flightStartYear, int flightStartMonth, int flightStartDay,
			String flightStartTime, int flightFinishYear, int flightFinishMonth, int flightFinishDay,
			String flightFinishTime, String startPoint, String finishPoint, int fee, String airlineName) {
		super();
		this.flightName = flightName;
		this.flightStartYear = flightStartYear;
		this.flightStartMonth = flightStartMonth;
		this.flightStartDay = flightStartDay;
		this.flightStartTime = flightStartTime;
		this.flightFinishYear = flightFinishYear;
		this.flightFinishMonth = flightFinishMonth;
		this.flightFinishDay = flightFinishDay;
		this.flightFinishTime = flightFinishTime;
		this.startPoint = startPoint;
		this.finishPoint = finishPoint;
		this.fee = fee;
		this.airlineName = airlineName;
	}


	
	@Override
	public String toString() {
		return "Flight [flightName=" + flightName + ", flightStartYear=" + flightStartYear + ", flightStartMonth="
				+ flightStartMonth + ", flightStartDay=" + flightStartDay + ", flightStartTime=" + flightStartTime
				+ ", flightFinishYear=" + flightFinishYear + ", flightFinishMonth=" + flightFinishMonth
				+ ", flightFinishDay=" + flightFinishDay + ", flightFinishTime=" + flightFinishTime + ", startPoint="
				+ startPoint + ", finishPoint=" + finishPoint + ", fee=" + fee + "]" +"\n";
	}


	public String getAirlineName() {
		return airlineName;
	}
	
	public int getFee() {
		return fee;
	}


	public void setFee(int fee) {
		this.fee = fee;
	}


	public String getFlightName() {
		return flightName;
	}


	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}


	public int getFlightStartYear() {
		return flightStartYear;
	}


	public void setFlightStartYear(int flightStartYear) {
		this.flightStartYear = flightStartYear;
	}


	public int getFlightStartMonth() {
		return flightStartMonth;
	}


	public void setFlightStartMonth(int flightStartMonth) {
		this.flightStartMonth = flightStartMonth;
	}


	public int getFlightStartDay() {
		return flightStartDay;
	}


	public void setFlightStartDay(int flightStartDay) {
		this.flightStartDay = flightStartDay;
	}


	public String getFlightStartTime() {
		return flightStartTime;
	}


	public void setFlightStartTime(String flightStartTime) {
		this.flightStartTime = flightStartTime;
	}


	public int getFlightFinishYear() {
		return flightFinishYear;
	}


	public void setFlightFinishYear(int flightFinishYear) {
		this.flightFinishYear = flightFinishYear;
	}


	public int getFlightFinishMonth() {
		return flightFinishMonth;
	}


	public void setFlightFinishMonth(int flightFinishMonth) {
		this.flightFinishMonth = flightFinishMonth;
	}


	public int getFlightFinishDay() {
		return flightFinishDay;
	}


	public void setFlightFinishDay(int flightFinishDay) {
		this.flightFinishDay = flightFinishDay;
	}


	public String getFlightFinishTime() {
		return flightFinishTime;
	}


	public void setFlightFinishTime(String flightFinishTime) {
		this.flightFinishTime = flightFinishTime;
	}


	public String getStartPoint() {
		return startPoint;
	}


	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}


	public String getFinishPoint() {
		return finishPoint;
	}


	public void setFinishPoint(String finishPoint) {
		this.finishPoint = finishPoint;
	}



	
}