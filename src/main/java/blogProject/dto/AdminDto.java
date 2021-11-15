package blogProject.dto;

import java.io.Serializable;

//MVC:
//Model alanıdır: DTO:Data Transfer Object
public class AdminDto extends CommonProperty implements Serializable {

	private static final long serialVersionUID = -6214174547778684454L;

	// class degiskeni
	private int registerNumberOfRecords;

	// parametresiz constructor
	public AdminDto() {
		this.registerNumberOfRecords = 0;
	}

	// parametreli constructor
	public AdminDto(int id, String name, String surName, String telNumber, String emailAddress, String password,
			int registerNumberOfRecords) {
		super(id, name, surName, telNumber, emailAddress, password);
		this.registerNumberOfRecords = registerNumberOfRecords;
	}

	// to String methodu
	@Override
	public String toString() {
		return "AdminDto [registerNumberOfRecords=" + registerNumberOfRecords + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getSurName()=" + getSurName() + ", getTelNumber()=" + getTelNumber()
				+ ", getEmailAddress()=" + getEmailAddress() + ", getPassword()=" + getPassword() + ", getCreateDate()="
				+ getCreateDate() + ", getClass()=" + getClass() + "]";
	}

	// getter and setter
	public int getRegisterNumberOfRecords() {
		return registerNumberOfRecords;
	}

	public void setRegisterNumberOfRecords(int registerNumberOfRecords) {
		this.registerNumberOfRecords = registerNumberOfRecords;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}
}
