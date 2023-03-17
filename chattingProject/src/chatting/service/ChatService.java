package chatting.service;

import java.util.ArrayList;

import chatting.dao.ChatDao;
import chatting.dto.ChatDto;

public class ChatService {
	
	ChatDao chatDao;
	
	public ChatService() {
		chatDao = new ChatDao();
	}
	
	public int InsertChat(ChatDto chatDto) {
		int resultRowCount = 0;
		String chat = chatDto.getContent();

		// 채팅 내용이 빈칸이면 입력 x
		if (chat.equals("")) {
			return resultRowCount;
		}
		
		resultRowCount = chatDao.insertChat(chatDto);
		return resultRowCount;
	}
	
	public ArrayList<ChatDto> selectChat(){
//		ArrayList<ChatDto> chatDtoArray = null;
//		chatDtoArray = chatDao.selectChatContent();
		
		return chatDao.selectChatContent();
	}
}
