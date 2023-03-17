package chatting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chatting.dto.ChatDto;
import chatting.utils.DBHelper;

public class ChatDao implements IChatDao{
	
	private DBHelper dbHelper;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ChatDao() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}
	
	@Override
	public int insertChat(ChatDto chatDto) {
		int resultRowCount = 0;
		String query = "insert into chat (userId,content) "
				+ "VALUES (?,?); ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, chatDto.getUserId()+"");
			pstmt.setString(2, chatDto.getContent());
			resultRowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(">> blogDAO save에서 에러 발생 <<");
			e.printStackTrace();
		}
		
		return resultRowCount;
	}

	@Override
	public ArrayList<ChatDto> selectChatContent() {
		ArrayList<ChatDto> chatDtoArray = new ArrayList<>();
		String query = " SELECT * " + "FROM chat ";

		try {
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ChatDto chatDto = new ChatDto();
				
				chatDto.setId(rs.getInt("id"));
				chatDto.setContent(rs.getString("content"));
				chatDto.setUserId(rs.getInt("userId"));
				
				chatDtoArray.add(chatDto);
			}

		} catch (SQLException e) {
			System.out.println(">> ChatDao select(int id) 에러 발생 <<");
			e.printStackTrace();
		}
		
		return chatDtoArray;
	}
	
	
}
