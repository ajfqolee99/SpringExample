package com.ajfqo.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ajfqo.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// id가 3인 행 조회 후 리턴
	// 정확히 조회되는 결과가 있어서 그 결과를 리턴되는 타입이 정확히 지정되어야함.
	public Review selectReview(@Param("id") int id);
	
	// 수행된 행의 개수 return
	public int insertReview(
			@Param("storeId") int storeId
			,@Param("menu") String menu
			,@Param("userName") String userName
			,@Param("point") double point
			,@Param("review") String review);
	
	public int insertReviewByOject(Review review);
	
}
