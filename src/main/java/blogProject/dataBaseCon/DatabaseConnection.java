package blogProject.dataBaseCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	// database bağlantısını kuracak class
	private Connection connection;

	// url username password çağırmak -- altta static ile obje olusturduk
	private static DatabaseInformation databaseInformation;

	// static -- nullPointer Excepitoni bunu yaparak engelliyoruz
	static {
		databaseInformation = new DatabaseInformation();
	}

	// database bağlanmak için zorunlu yerdir.
	private String url = databaseInformation.getUrl();
	private String userName = databaseInformation.getUserName();
	private String password = databaseInformation.getPassword();

	// singleton design pattern 1.özellik
	private static DatabaseConnection instance;

	// singleton design pattern 2.özellik
	private DatabaseConnection() {
		try {
			Class.forName(databaseInformation.getForNameData());
			// System.out.println("postgresql-42.3.1 jar Driver Yüklendi");

			this.connection = DriverManager.getConnection(url, userName, password);
			// System.out.println("Başarılı Baglantı.");

		} catch (Exception e) {
			System.out.println("Database Baglanti Sirasinda Hatalar Meydana Geldi");
			e.printStackTrace();
		}
	}

	// singleton design pattern 3.özellik
	// syncronized
	public static DatabaseConnection getInstance() {
		try {
			if (instance == null) {
				instance = new DatabaseConnection();
			} else

			if (instance.getConnection().isClosed()) {
				instance = new DatabaseConnection();
			}
		} catch (SQLException e) {

			System.out.println("Singleten Hatasi");
		}
		return instance;
	}

	// getter and setter
	public Connection getConnection() {
		return connection;
	}

}
