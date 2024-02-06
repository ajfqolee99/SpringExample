package com.ajfqo.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ajfqo.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// id가 3인 행 조회 후 리턴
	public Review selectReview(@Param("id") int id);
	
}
