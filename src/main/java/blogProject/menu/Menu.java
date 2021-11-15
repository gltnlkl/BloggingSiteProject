package blogProject.menu;

import blogProject.utillsGen.GenUtil;

public class Menu {

	MenuItems menuItems = new MenuItems();
	MenuMethod menuMethod = new MenuMethod();

	public void mainMenu() {

		boolean isloop = true;

		do {

			int inputNumber = GenUtil.showMenuI("BLOG PROJESI GIRIS", menuItems.mainMenuItems());

			switch (inputNumber) {

			case 0:

				System.out.println("Yeni Admin Girisi:\n");

				boolean checkAdminLogin = menuMethod.adminFirstLogin();

				if (checkAdminLogin) {

					secondaryMenuAdmin();
				} else

					isloop = true;

				break;

			case 1:

				System.out.println("Mevcut Admin Girisi:\n");

				boolean adminLogin = menuMethod.adminLogin();

				if (adminLogin) {

					secondaryMenuAdmin();

				} else
					System.out.println("Hatali giris. Sistemden cikis saglaniyor.");
				isloop = false;

				break;

			case 2:

				System.out.println("Yeni Kullanici Girisi:\n");

				boolean checkUserLogin = menuMethod.userInsert();

				if (checkUserLogin) {

					secondaryMenuUser();

				} else

					isloop = true;
				break;

			case 3:
				System.out.println("Mevcut Kullanici Girisi:\n");

				boolean userLogin = menuMethod.userLogin();

				if (userLogin) {

					secondaryMenuUser();

				} else {

					System.out.println("Hatali giris. Sistemden cikis saglaniyor.");
					isloop = false;
				}

				break;

			case 4:

				System.out.println("Sistemden Cikiliyor.\nIyi Gunler Dileriz.");
				isloop = false;
				break;

			}
		} while (isloop);

	}

	public void secondaryMenuUser() {

		boolean isloop = true;

		do {

			switch (GenUtil.showMenuI("BLOG PROJESI ISLEMLER", menuItems.secondaryMenuItemsUser())) {

			case 0:

				System.out.println("Blog Yazma:\n");

				break;
			case 1:

				System.out.println("Blog Okuma:\n");

				break;
			case 2:

				System.out.println("Chat Uygulamasi:\n");

				menuMethod.chatApplication();

				break;

			case 3:

				System.out.println("Sistemden Cikiliyor.\nIyi Gunler Dileriz.");
				isloop = false;
				break;

			}
		} while (isloop);

	}

	public void secondaryMenuAdmin() {

		boolean isloop = true;

		do {

			switch (GenUtil.showMenuI("BLOG PROJESI ISLEMLER", menuItems.secondaryMenuItemsAdmin())) {

			case 0:

				System.out.println("Kullanici kayit verileri:\n");

				menuMethod.adminRecords();

				break;
			case 1:

				System.out.println("Aktif kullanici listesi:\n");

				menuMethod.activeUserList();

				break;
			case 2:

				System.out.println("Bloke kullanici listesi:\n");

				menuMethod.passiveUserList();

				break;
			case 3:

				System.out.println("Blog Yazma:\n");

				break;
			case 4:

				System.out.println("Blog Okuma:\n");

				break;
			case 5:

				System.out.println("Chat Uygulamasi:\n");

				menuMethod.chatApplication();

				break;

			case 6:

				System.out.println("Sistemden Cikiliyor.\nIyi Gunler Dileriz.");
				isloop = false;
				break;

			}
		} while (isloop);

	}
}
