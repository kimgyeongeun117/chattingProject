package chatting.service;

import chatting.dao.UserDao;
import chatting.dto.UserDto;

public class UserService {

private UserDao userDAO;
	
	public UserService() {
		userDAO = new UserDao();
	}
	
	public String signUp(UserDto user) {
		String msg = "";
		if(user.getUserName().equals("")) {
			msg = "사용자 이름을 입력해주세요";
			System.out.println(msg);
			return msg;
		}
		int resultRow =userDAO.saveUser(user);
		if(resultRow == 0) {
			return null;
		}
		
		return resultRow+"";
	}
	
	public UserDto checkUser(String username,String password) {
		boolean isValid = true;
		if(username.equals("")) {
			isValid = false;
		} else if(password.equals("")) {
			isValid = false;
		}
		
		UserDto userDTO = null;
		if(isValid) {
			userDTO = userDAO.selectUserByUsernameAndPassword(username, password);
		}
		
		return userDTO;
	}

}
