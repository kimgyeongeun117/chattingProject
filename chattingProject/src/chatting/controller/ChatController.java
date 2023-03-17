package chatting.controller;

import java.util.ArrayList;

import chatting.dto.ChatDto;
import chatting.service.ChatService;

public class ChatController {
	
	private ChatService chatService;
	
	public ChatController() {
		chatService = new ChatService();
	}
	
	// db에 채팅 입력
	public int requestInsertChat(ChatDto chatDto) {
		int resultRow = 0;
		
		resultRow = chatService.InsertChat(chatDto);
		
		return resultRow;
	}
	
	public ArrayList<ChatDto> requestSelectChat(){
		
		return chatService.selectChat();
	}
}
