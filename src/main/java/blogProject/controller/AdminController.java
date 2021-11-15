package blogProject.controller;

import java.util.ArrayList;
import java.util.List;

import blogProject.dao.AdminDao;
import blogProject.dao.IDAOImplements;
import blogProject.dto.AdminDto;

public class AdminController implements IDAOImplements<AdminDto> {

	// değişken
	private AdminDto adminDto;
	private AdminDao adminDao;
	private List<AdminDto> adminList;

	// parametresiz constructor
	public AdminController() {
		adminDto = new AdminDto();
		adminDao = new AdminDao();
		adminList = new ArrayList<AdminDto>();
	}

	public void writeToTheFolder(String path, AdminDto a) {
		adminDao.writeToTheFolder(path, a);
	}

	public AdminDto readFromTheFolder(String path) {
		return adminDao.readFromTheFolder(path);

	}

	public int readAdminNumberOfRecords() {

		return adminDao.readAdminNumberOfRecords();

	}

	@Override
	public boolean insert(AdminDto t) {
		return adminDao.insert(t);

	}

	@Override
	public void update(AdminDto a) {
		adminDao.update(a);

	}

	@Override
	public void delete(AdminDto a) {
		adminDao.delete(a);

	}

	@Override
	public ArrayList<AdminDto> list() {
		return adminDao.list();
	}

	// getter and setter
	public AdminDto getAdminDto() {
		return adminDto;
	}

	public void setAdminDto(AdminDto adminDto) {
		this.adminDto = adminDto;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public List<AdminDto> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<AdminDto> adminList) {
		this.adminList = adminList;
	}

}
