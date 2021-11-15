package blogProject.dto;

import java.io.Serializable;

/*
 * isActive:boolean"
 * HesCodes: String
 * temporaryUUID: UUID
 */
public class UserDto extends CommonProperty implements Serializable {

	private static final long serialVersionUID = -6909316477482845301L;

	// class degiskeni
	private boolean isActive;
	private String HesCodes;

	// parametresiz constructor
	public UserDto() {
		this.isActive = true;
		this.HesCodes = "";
	}

	// parametreli constructor
	public UserDto(int id, String name, String surName, String telNumber, String emailAddress, String password,
			boolean isActive, String hesCodes) {
		super(id, name, surName, telNumber, emailAddress, password);
		this.isActive = isActive;
		HesCodes = hesCodes;
	}

	public UserDto(int id, String name, String surName, String telNumber, String emailAddress) {
		super(id, name, surName, telNumber, emailAddress);

	}

	// to String methodu

	@Override
	public String toString() {
		return "[ Id = " + getId() + ", isim = " + getName() + ", soyisim = " + getSurName() + ", telefon numarasi = "
				+ getTelNumber() + ", mail adresi = " + getEmailAddress() + "]";
	}

	// getter and setter
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getHesCodes() {
		return HesCodes;
	}

	public void setHesCodes(String hesCodes) {
		HesCodes = hesCodes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
