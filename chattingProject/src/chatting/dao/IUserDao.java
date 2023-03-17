package chatting.dao;

import chatting.dto.UserDto;

public interface IUserDao {
	
	int saveUser(UserDto user);		//유저 회원가입
	UserDto selectUserByUsernameAndPassword(String userName,String password);	// 유저 조회
}
