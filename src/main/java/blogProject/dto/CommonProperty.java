package blogProject.dto;

import java.io.Serializable;
import java.sql.Date;

/*
 * commonPropery classının attributesları
 * -id:int
 * -name: String
 * -surname: String
 * -telNumber: String
 * -emailAddress: String
 * -password: String
 * -createDate: Date
 */

public class CommonProperty implements Serializable {

	private static final long serialVersionUID = -3586488201061742696L;

	// class degiskeni
	private int id;
	private String name;
	private String surName;
	private String telNumber;
	private String emailAddress;
	private String password;
	private Date createDate;

	// parametresiz constructor
	public CommonProperty() {

		this.name = "";
		this.surName = "";
		this.telNumber = "";
		this.emailAddress = "";
		this.password = "";

	}

	// parametreli constructor
	public CommonProperty(int id, String name, String surName, String telNumber, String emailAddress, String password) {
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.telNumber = telNumber;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public CommonProperty(int id, String name, String surName, String telNumber, String emailAddress) {
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.telNumber = telNumber;
		this.emailAddress = emailAddress;

	}

	@Override
	public String toString() {
		return "CommonProperty [id=" + id + ", name=" + name + ", surName=" + surName + ", telNumber=" + telNumber
				+ ", emailAddress=" + emailAddress + ", password=" + password + ", createDate=" + createDate + "]";
	}

	// getter and setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
