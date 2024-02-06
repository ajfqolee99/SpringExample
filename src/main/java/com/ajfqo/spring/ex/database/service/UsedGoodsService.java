package com.ajfqo.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajfqo.spring.ex.database.domain.UsedGoods;
import com.ajfqo.spring.ex.database.repository.UsedGoodsRepository;

// 로직(Business) 담당
@Service
public class UsedGoodsService {
	
	// 의존성 주입
	// usedgoodsrepository -> 이 변수에 객체를 주입 (객체를 사용할때 알아서/ 무분별하게 만들어지지 않도록 스프링에서 관리)
	@Autowired
	private UsedGoodsRepository usedGoodsRepository; 
	
	// 중고물품 게시글 리스트
	public List<UsedGoods> getUsedGoodsList() {
		
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		
		return usedGoodsList;
	}
	
	
}
