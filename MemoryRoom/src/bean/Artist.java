package bean;

import java.util.List;

public class Artist{
//	private int id;							// SQL用に使うid
	private String name;					// 名前
	private java.util.Date birthDay;		// 誕生日
	private String birthPlice;				// 出身地
	private String bloodType;				// 血液型
	private String gender;					// 性別
	private String lebel;					// 所属レーベル
	private String introduct;				// 紹介文
	private List<String> cdList;			// 本人名義のCD

//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.util.Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(java.util.Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getBirthPlice() {
		return birthPlice;
	}
	public void setBirthPlice(String birthPlice) {
		this.birthPlice = birthPlice;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLebel() {
		return lebel;
	}
	public void setLebel(String lebel) {
		this.lebel = lebel;
	}
	public String getIntroduct() {
		return introduct;
	}
	public void setIntroduct(String introduct) {
		this.introduct = introduct;
	}
	public List<String> getCdList() {
		return cdList;
	}
	public void setCdList(String cdList) {
		this.cdList.add(cdList);
	}
	
}
