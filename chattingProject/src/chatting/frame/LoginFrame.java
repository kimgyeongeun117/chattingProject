package chatting.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import chatting.controller.UserController;
import chatting.dto.UserDto;
import chatting.socket.ClientFile;
import chatting.socket.ServerFile;

public class LoginFrame extends JFrame{
	UserController userController;
	UserDto userDto;
	
	private JButton loginButton;
	private JButton signUpButton;
	private JTextField idField; 
	private JPasswordField passwordField;
	private JLabel idLabel;
	private JLabel passwordLabel;
	
	public LoginFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle("채팅 프로그램");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		userController = new UserController();
		userDto = new UserDto();
		
		loginButton = new JButton("로그인");
		signUpButton = new JButton("회원가입");
		idField = new JTextField(); 
		passwordField = new JPasswordField();
		idLabel = new JLabel("아이디");
		passwordLabel = new JLabel("비밀번호");
	};
	
	private void setInitLayout() {
		setLayout(null);
		
		idLabel.setSize(100,30);
		passwordLabel.setSize(100,30);
		idField.setSize(300,30);
		passwordField.setSize(300,30);
		loginButton.setSize(150,30);
		signUpButton.setSize(150,30);
		
		idLabel.setLocation(200,200);
		idField.setLocation(300,200);
		passwordLabel.setLocation(200,300);
		passwordField.setLocation(300,300);
		loginButton.setLocation(300, 500);
		signUpButton.setLocation(300, 600);
		
		passwordField.setEchoChar('*');
		
		add(idLabel);
		add(passwordLabel);
		add(idField);
		add(passwordField);
		add(loginButton);
		add(signUpButton);
		setVisible(true);
	}
	
	private void addEventListener() {
		loginButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] secret_pw = passwordField.getPassword();
				StringBuffer password = new StringBuffer();
				
				for (char c : secret_pw) {
					password.append(Character.toString(c));
				}
				
				if((userDto = userController.requestSignIn(idField.getText(), password.toString()))!=null) {
					new ChatFrame(userDto);
					setVisible(false);
				}
			}
		});
		
		signUpButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				userDto.setUserName(idField.getText());
				userDto.setPassword(passwordField.getPassword().toString());
				
				userController.requestSignUp(userDto, "localhost");
			}
		});
	}
	
	public static void main(String[] args) {
		
		new LoginFrame();
	}
}
