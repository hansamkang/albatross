package com.example.albatross.domain.vo;

import lombok.Data;

// 글들을 List로 가지고 오기위한 페이지 정보를 전송하기 위한 DTO
@Data
public class PageInfo {
	// 페이지 번호 Default = 1;
	private int pageNum;
	// 한번에 가지고 올 페이지 량 Default = 20;
	private int amount;
	
	// Default 
	public PageInfo() {
		this(1, 10);
	}
	
	public PageInfo(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	
}
