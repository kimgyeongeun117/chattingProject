package chatting.controller;

import chatting.dto.UserDto;
import chatting.service.UserService;

public class UserController {
	
private UserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
	// 회원가입 처리 요청
	public String requestSignUp(UserDto user,String host) {
		String response = "외부에서는 회원 가입이 안됩니다.";
		if(host.equals("localhost")) {
			response = userService.signUp(user);
		}
		
		return response;
	}
	
	// 가입된 유저 정보 찾기 요청
	public UserDto requestSignIn(String username,String password) {
		UserDto responseUserDto = userService.checkUser(username, password);
		
		return responseUserDto;
	}
}
