package blogProject.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import blogProject.dto.AdminDto;
import blogProject.utillsGen.GenUtil;

public class AdminDao implements IDAOImplements<AdminDto> {

	public void writeToTheFolder(String path, AdminDto t) {

		File file = new File(path);

		try {
			FileOutputStream foutput = new FileOutputStream(file);
			ObjectOutputStream output = new ObjectOutputStream(foutput);
			output.writeObject(t);
			output.flush();
			output.close();

		} catch (IOException ex) {

			System.err.println("Hata!\nDosyaya Yazilamadi.");
			ex.printStackTrace();

		} catch (Exception e) {

			System.err.println("Hata!\nDosyaya Yazilamadi.");
			e.printStackTrace();

		}
	}

	public AdminDto readFromTheFolder(String path) {

		AdminDto adminDto = null;

		File file = new File(path);

		try {

			FileInputStream fInput = new FileInputStream(file);
			ObjectInputStream input = new ObjectInputStream(fInput);

			if ((adminDto = (AdminDto) input.readObject()) != null)
				input.close();

			return adminDto;

		} catch (ClassNotFoundException | EOFException ex) {

			System.out.println(ex.getMessage());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return adminDto;

	}

	@Override

	public boolean insert(AdminDto t) {

		try (Connection connection = getInterfaceConnection()) {
			String sql = "insert into admin_blog (admin_name,admin_surname,admin_tel_number,admin_email_address,admin_password) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getSurName());
			preparedStatement.setString(3, t.getTelNumber());
			preparedStatement.setString(4, t.getEmailAddress());
			preparedStatement.setString(5, GenUtil.encoderPassword(t.getPassword()));

			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				return true;
			} else {
				System.out.println("\nEksik veri girisi. Lutfen tekrar deneyiniz. ");
			}
			return false;
		} catch (SQLException e) {
			System.out.println("\nEksik veri girisi. Lutfen tekrar deneyiniz. ");

			return false;
		}

	}

	@Override

	public void update(AdminDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "update admin_blog set admin_name=?,admin_surname=?,admin_tel_number=?,admin_email_addres=?,admin_password=? where admin_id=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getSurName());
			preparedStatement.setString(3, t.getTelNumber());
			preparedStatement.setString(4, t.getEmailAddress());
			preparedStatement.setString(5, t.getPassword());
			preparedStatement.setInt(6, t.getId());

			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {

			} else {
				System.out.println("\nEksik veri girisi. Lutfen tekrar deneyiniz. ");
			}

		} catch (SQLException e) {
			System.out.println("\nEksik veri girisi. Lutfen tekrar deneyiniz. ");

		}
	}

	@Override

	public void delete(AdminDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "Delete from admin_blog where admin_id=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, t.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(AdminDao.class + " Güncelleme başarılı");
			} else {
				System.out.println("Güncelleme sırasında bir hata meydana geldi");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " AdminDao Hata meydana geldi ");
			e.printStackTrace();
		}

	}

	@Override

	public ArrayList<AdminDto> list() {

		ArrayList<AdminDto> adminList = new ArrayList<AdminDto>();
		AdminDto adt;

		try (Connection connection = getInterfaceConnection()) {
			String sql = "Select * from admin_blog;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			// database verılerlını alıyoruz
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				adt = new AdminDto();
				adt.setId(resultSet.getInt("admin_id"));
				adt.setEmailAddress(resultSet.getString("admin_email_addres"));
				adt.setName(resultSet.getString("admin_name"));
				adt.setPassword(resultSet.getString("admin_password"));
				adt.setSurName(resultSet.getString("admin_surname"));
				adt.setCreateDate(resultSet.getDate("created_date"));
				adt.setRegisterNumberOfRecords(resultSet.getInt("admin_number_of_records"));
				adt.setTelNumber(resultSet.getString("admin_tel_number"));
				adminList.add(adt);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + " AdminDao Hata meydana geldi ");
			e.printStackTrace();
		}

		return adminList;
	}

	public int readAdminNumberOfRecords() {

		int adminNumberOfRecords = 0;

		try (Connection connection = getInterfaceConnection()) {

			String sql = "SELECT admin_number_of_records FROM admin_blog WHERE admin_id IN(1);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			// database verılerlını alıyoruz
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				adminNumberOfRecords = resultSet.getInt("admin_number_of_records");

				return adminNumberOfRecords;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();
		}

		return adminNumberOfRecords;
	}

}
