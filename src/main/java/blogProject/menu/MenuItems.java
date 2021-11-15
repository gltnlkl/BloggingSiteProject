package blogProject.menu;

import java.util.HashMap;
import java.util.Map;

public class MenuItems {

	protected Map<Integer, String> mainMenuItems() {

		Map<Integer, String> mapList = new HashMap<Integer, String>();

		mapList.put(0, "Yeni Admin Girisi");
		mapList.put(1, "Mevcut Admin Girisi");
		mapList.put(2, "Yeni Kullanici Girisi");
		mapList.put(3, "Mevcut Kullanici Girisi");
		mapList.put(4, "Uygulamadan Cikis");

		return mapList;

	}

	protected Map<Integer, String> secondaryMenuItemsUser() {

		Map<Integer, String> mapList = new HashMap<Integer, String>();

		mapList.put(0, "Blog Yazma");
		mapList.put(1, "Blog Okuma");
		mapList.put(2, "Chat Uygulamasi");
		mapList.put(3, "Uygulamadan Cikis");

		return mapList;

	}

	protected Map<Integer, String> secondaryMenuItemsAdmin() {

		Map<Integer, String> mapList = new HashMap<Integer, String>();

		mapList.put(0, "Kullanici kayit verileri");
		mapList.put(1, "Aktif kullanici listesi");
		mapList.put(2, "Bloke kullanici listesi");
		mapList.put(3, "Blog Yazma");
		mapList.put(4, "Blog Okuma");
		mapList.put(5, "Chat Uygulamasi");
		mapList.put(6, "Uygulamadan Cikis");

		return mapList;

	}

}
