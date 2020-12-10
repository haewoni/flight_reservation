package com.itwill.passenger;

import java.io.Serializable;

public class Passenger implements Serializable {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String birthDate;
	private String phoneNo;



	public Passenger() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Passenger(String memberId, String memberPw, String memberName, String birthDate, String phoneNo) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.birthDate = birthDate;
		this.phoneNo = phoneNo;
		
	}
	

	
	
	public boolean matchPassword(String password) {
		if (this.memberPw.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	

	
	

	@Override
	public String toString() {
		return "Passenger [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", birthDate=" + birthDate + ", phoneNo=" + phoneNo + "]";
	}


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


}
