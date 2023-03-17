package chatting.dao;

import java.util.ArrayList;

import chatting.dto.ChatDto;

public interface IChatDao {
	int insertChat(ChatDto chatDto);
	ArrayList<ChatDto> selectChatContent();
}
