package blogProject.controller;

import java.util.ArrayList;
import java.util.List;

import blogProject.dao.IDAOImplements;
import blogProject.dao.UserDao;
import blogProject.dto.UserDto;

public class UserController implements IDAOImplements<UserDto> {

	// değişkenlerimiz
	private UserDto userDto;
	private UserDao userDao;
	private List<UserDto> userList;

	// parametresiz constructor
	public UserController() {
		userDto = new UserDto();
		userDao = new UserDao();
		userList = new ArrayList<UserDto>();
	}

	public void userActivation(UserDto t) {
		userDao.userActivation(t);
	}

	public String checkUserPassword(UserDto t) {
		return userDao.checkUserPassword(t);
	}

	@Override
	public boolean insert(UserDto t) {
		return userDao.insert(t);

	}

	@Override
	public void update(UserDto t) {
		userDao.update(t);

	}

	@Override
	public void delete(UserDto t) {
		userDao.delete(t);

	}

	@Override
	public ArrayList<UserDto> list() {
		return userDao.list();

	}

	public ArrayList<UserDto> listPassive() {
		return userDao.listPassive();

	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<UserDto> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDto> userList) {
		this.userList = userList;
	}

}
