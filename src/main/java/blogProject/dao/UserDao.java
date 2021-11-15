package blogProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import blogProject.dto.UserDto;
import blogProject.utillsGen.GenUtil;

public class UserDao implements IDAOImplements<UserDto> {

	@Override
	public boolean insert(UserDto u) {

		try (Connection connection = getInterfaceConnection()) {

			String sql = "insert into user_blog (user_name,user_surname,user_tel_number,user_email_address,user_password,admin_id) values(?,?,?,?,?,1)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, u.getName());
			preparedStatement.setString(2, u.getSurName());
			preparedStatement.setString(3, u.getTelNumber());
			preparedStatement.setString(4, u.getEmailAddress());
			preparedStatement.setString(5, GenUtil.encoderPassword(u.getPassword()));

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

	public void userActivation(UserDto u) {

		try (Connection connection = getInterfaceConnection()) {

			String sql = "UPDATE user_blog SET user_is_active=? WHERE user_email_address in(?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setBoolean(1, u.isActive());
			preparedStatement.setString(2, u.getEmailAddress());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();
		}
	}

	public String checkUserPassword(UserDto u) {

		UserDto userDto = null;

		try (Connection connection = getInterfaceConnection()) {

			String sql = " SELECT user_password FROM user_blog WHERE user_email_address in(?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, u.getEmailAddress());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				userDto = new UserDto();

				userDto.setPassword(GenUtil.decoderPassword(resultSet.getString("user_password")));
				return userDto.getPassword();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();

		}
// TO DO KONTROL ET
		return null;

	}

	@Override
	public void update(UserDto u) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "update user_blog set user_name=?,user_surname=?,user_tel_number=?,user_email_addres=?,user_password=? where user_id=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, u.getName());
			preparedStatement.setString(2, u.getSurName());
			preparedStatement.setString(3, u.getTelNumber());
			preparedStatement.setString(4, u.getEmailAddress());
			preparedStatement.setString(5, u.getPassword());
			preparedStatement.setInt(6, u.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(UserDao.class + " Güncelleme başarılı");
			} else {
				System.out.println("Güncelleme sırasında bir hata meydana geldi");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(UserDto u) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "Delete from user_blog where user_id=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, u.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				// System.out.println(UserDao.class + " Güncelleme başarılı");
			} else {
				// System.out.println("Güncelleme sırasında bir hata meydana geldi");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<UserDto> list() {

		ArrayList<UserDto> userList = new ArrayList<UserDto>();
		UserDto udt;

		try (Connection connection = getInterfaceConnection()) {
			String sql = "SELECT user_id , user_name, user_surname , user_tel_number , user_email_address FROM user_blog WHERE user_is_active IN(true);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			// database verılerlını alıyoruz
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				udt = new UserDto();
				udt.setId(resultSet.getInt("user_id"));
				udt.setEmailAddress(resultSet.getString("user_email_address"));
				udt.setName(resultSet.getString("user_name"));
				udt.setSurName(resultSet.getString("user_surname"));
				udt.setTelNumber(resultSet.getString("user_tel_number"));
				userList.add(udt);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();
		}

		return userList;
	}

	public ArrayList<UserDto> listPassive() {

		ArrayList<UserDto> userList = new ArrayList<UserDto>();
		UserDto udt;

		try (Connection connection = getInterfaceConnection()) {
			String sql = "SELECT user_id,user_name, user_surname , user_tel_number , user_email_address FROM user_blog WHERE user_is_active IN(false); ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			// database verılerlını alıyoruz
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				udt = new UserDto();
				udt.setId(resultSet.getInt("user_id"));
				udt.setEmailAddress(resultSet.getString("user_email_address"));
				udt.setName(resultSet.getString("user_name"));
				udt.setSurName(resultSet.getString("user_surname"));
				udt.setTelNumber(resultSet.getString("user_tel_number"));
				userList.add(udt);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + " Hata meydana geldi ");
			e.printStackTrace();
		}

		return userList;
	}

}
