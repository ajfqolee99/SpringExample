package com.ajfqo.spring.ex.jsp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ajfqo.spring.ex.jsp.domain.User;

@Mapper
public interface UserRepository {
	
	public int insertUser(
			@Param("name") String name
			,@Param("birthday") String birthday
			,@Param("email") String email);
	
	public int insertUserByObject(User user);
	
	// 가장 최근에 삽입된 행 조회
	public User selectLastUser();
	
	public List<User> selectUserList();
	
	public int selectCountEmail(@Param("email")String email);
	
}
