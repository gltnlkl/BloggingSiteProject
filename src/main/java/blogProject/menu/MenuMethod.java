package blogProject.menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import blogProject.controller.AdminController;
import blogProject.controller.UserController;
import blogProject.dataBaseCon.Path;
import blogProject.dto.AdminDto;
import blogProject.dto.UserDto;
import blogProject.socket.Client;
import blogProject.socket.Server;
import blogProject.utillsGen.GenUtil;

public class MenuMethod {

	public boolean adminFirstLogin() {

		String mail = GenUtil.readString("Lütfen admin maili giriniz");
		String password = GenUtil.readFString("Lütfen şifre giriniz");
		String name = GenUtil.readString("Lütfen admin ismi giriniz");
		String surName = GenUtil.readString("Lütfen admin soyIsmi giriniz");
		String phoneNum = GenUtil.readString("Lütfen admin telefon numarasi giriniz");

		AdminDto adminDto = new AdminDto();

		adminDto.setName(name);
		adminDto.setSurName(surName);
		adminDto.setTelNumber(phoneNum);
		adminDto.setEmailAddress(mail);
		adminDto.setPassword(password);

		AdminController adminController = new AdminController();
		// admin objesini local dosyaya yazdık
		adminController.writeToTheFolder(Path.PATH, adminDto);
		// database tablosuna obje bılgılerını gonderdık
		boolean bool = (adminController.insert(adminDto));
		if (bool = true) {

			System.out.println("\nKaydiniz oluşturuldu, Sisteme giris saglaniyor! \n");

			return bool;
		} else
			System.out.println("\nHatali giriş ana menüye yönlendiriliyorsunuz.\n");
		return false;

	}

	public boolean adminLogin() {

		boolean bool = true;
		int attempt = 5;
		while (attempt > -1) {
			String mail = GenUtil.readString("Lütfen admin maili giriniz");

			String password = GenUtil.readString("Lütfen şifre giriniz");

			boolean checkbool = adminCheckPassword(mail, password);

			if (checkbool) {

				System.out.println("\nBilgiler doğru, Sisteme giris saglaniyor! ");

				attempt = -1;

				bool = true;

			} else {

				System.out.println("Girilen bilgiler dogru degildir.");
				System.out.println("Kalan hakkiniz:" + (attempt - 1));

			}
			if (attempt == 1) {

				bool = false;

				System.out.println("5 kere yanlis girdiniz. Hesap bloke olmustur.");

				System.exit(0);
			}

			attempt--;

		}
		return bool;
	}

	public boolean adminCheckPassword(String mail, String password) {

		AdminDto adminDto = new AdminDto();

		AdminController adminController = new AdminController();

		adminDto = (adminController.readFromTheFolder(Path.PATH));

		if (mail.endsWith(adminDto.getEmailAddress()) && password.toUpperCase().endsWith(adminDto.getPassword())) {

			return true;

		} else
			return false;

	}

	public boolean userInsert() {

		String mail = GenUtil.readString("Lütfen kullanici maili giriniz");
		String password = GenUtil.readFString("Lütfen şifre giriniz");
		String name = GenUtil.readString("Lütfen kullanici ismi giriniz");
		String surName = GenUtil.readString("Lütfen kullanici soyIsmi giriniz");
		String phoneNum = GenUtil.readString("Lütfen kullanici telefon numarasi giriniz");

		UserDto userDto = new UserDto();
		userDto.setName(name);
		userDto.setSurName(surName);
		userDto.setTelNumber(phoneNum);
		userDto.setEmailAddress(mail);
		userDto.setPassword(password);

		UserController userController = new UserController();
		boolean bool = (userController.insert(userDto));
		if (bool = true) {
			userActivation(userDto, bool);
			System.out.println("\nKaydiniz oluşturuldu, Sisteme giris saglaniyor! \n");

			return bool;
		} else
			System.out.println("\nHatali giriş ana menüye yönlendiriliyorsunuz.\n");
		return false;

	}

	public void userActivation(UserDto userDto, boolean b) {

		userDto.setActive(b);
		userDto.getEmailAddress();

		UserController userController = new UserController();
		userController.userActivation(userDto);

	}

	public boolean userLogin() {

		boolean bool = true;
		int attempt = 5;

		while (attempt > -1) {

			String mail = "";
			String password = "";

			mail = GenUtil.readString("Lütfen kullanici maili giriniz");
			password = GenUtil.readFString("Lütfen şifre giriniz");

			UserDto userDto = new UserDto();
			userDto.setEmailAddress(mail);

			UserController userController = new UserController();

			String passwordFromDatabase = userController.checkUserPassword(userDto);

			if (password.equals(passwordFromDatabase)) {

				bool = true;

				// userActivation(userDto, bool); // sisteme ilk kayıt olundugunda
				// userActivation true oluyor burada gerek yok bu nedenle

				System.out.println("\nBilgiler doğru, Sisteme giris saglaniyor! ");

				attempt = -1;

			} else {
				System.out.println("Girilen bilgiler dogru degildir.");
				System.out.println("Kalan hakkiniz:" + (attempt - 1));
				//
				if (attempt == 1) {

					bool = false;

					userActivation(userDto, bool);

					System.out.println("5 kere yanlis girdiniz. Hesap bloke olmustur.");

					System.exit(0);

				}

				attempt--; // sifre yanlis ise her denemede attempt 1 azalacak.

			}
		}
		return bool;

	}

	public void adminRecords() {

		AdminController adminController = new AdminController();

		DateTimeFormatter shortDateFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM,
				FormatStyle.SHORT);

		int adminNumberOfRecords = adminController.readAdminNumberOfRecords();

		System.out.println(LocalDateTime.now().format(shortDateFormat) + " itibari ile toplam üye kullanıcı sayısı : "
				+ "[ " + adminNumberOfRecords + " ]" + " dir.");

	}

	public void activeUserList() {

		UserController userController = new UserController();

		ArrayList<UserDto> activeUserList = new ArrayList<UserDto>();

		activeUserList = userController.list();

		for (int i = 0; i < activeUserList.size(); i++) {

			System.out.println(activeUserList.get(i));

		}

	}

	public void passiveUserList() {

		UserController userController = new UserController();

		ArrayList<UserDto> passiveUserList = new ArrayList<UserDto>();

		passiveUserList = userController.listPassive();

		for (int i = 0; i < passiveUserList.size(); i++) {

			System.out.println(passiveUserList.get(i));

		}
	}

	public void chatApplication() {

		Server srv = new Server();
		Client clt = new Client();

		Thread s = new Thread(srv);
		s.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Thread c = new Thread(clt);
		c.run();

	}

}
