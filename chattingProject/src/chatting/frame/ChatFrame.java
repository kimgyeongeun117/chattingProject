package chatting.frame;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import chatting.controller.ChatController;
import chatting.dto.ChatDto;
import chatting.dto.UserDto;
import chatting.socket.ClientFile;

public class ChatFrame extends JFrame{
	
	private ChatController chatController;
	ClientFile client;
	
	private JLabel chatLabel;
	private JLabel inputLabel;
	private JLabel userLabel;
	private JTextArea chatArea;
	private JTextField inputField;
	private JTextField userField;
	private JButton logOutButton;
	private JButton exit;
	
	private UserDto userDto;
	
	public ChatFrame(UserDto userDto) {
		this.userDto = userDto;
		
		initData();
		setInitLayout();
		addEventListener();
		
		client = new ClientFile();
	}
	
	private void initData() {
		setTitle("채팅 프로그램");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		chatController = new ChatController();
		chatLabel = new JLabel("채팅창");
		inputLabel = new JLabel("입력");
		userLabel = new JLabel("유저 목록");
		chatArea = new JTextArea();
		inputField = new JTextField();
		userField = new JTextField();
		logOutButton = new JButton("로그아웃");
		exit = new JButton("종료");
	};
	
	private void setInitLayout() {
		setLayout(null);
		
		chatLabel.setSize(100,50);
		userLabel.setSize(100,50);
		inputLabel.setSize(100,50);
		chatArea.setSize(500,600);
		inputField.setSize(500,40);
		userField.setSize(100,300);
		logOutButton.setSize(100,50);
		exit.setSize(100,50);
		
		chatLabel.setLocation(200,10);
		userLabel.setLocation(10,10);
		inputLabel.setLocation(200,650);
		chatArea.setLocation(200,50);
		inputField.setLocation(200,700);
		userField.setLocation(10,50);
		logOutButton.setLocation(10, 550);
		exit.setLocation(10, 650);
		
		chatArea.setEnabled(false);
		userField.setEnabled(false);
		
		add(userLabel);
		add(chatLabel);
		add(inputLabel);
		add(chatArea);
		add(inputField);
		add(userField);
		add(logOutButton);
		add(exit);
		setVisible(true);
	}
	
	private void addEventListener() {
		inputField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==13||e.getKeyCode()==10) {
					StringBuffer chatBuffer = new StringBuffer();
					chatBuffer.append(inputField.getText()+"\n");
					
					client.setMsg(chatBuffer.toString());
					chatArea.setText(chatBuffer.toString());
				}
			}
		});
		
	}
}
