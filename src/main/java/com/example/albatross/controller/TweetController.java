package com.example.albatross.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.albatross.domain.vo.PageInfo;
import com.example.albatross.domain.vo.TweetDTO;
import com.example.albatross.domain.vo.TweetVO;
import com.example.albatross.service.TweetService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweet/*")
@Log4j
public class TweetController {
	private final TweetService tweetService;
	
	@GetMapping("/test")
    public String test() {
		log.info("GET 요청이 잘 되었습니다.");
        return "Get 요청이 잘 처리되었습니다.";
    }
	
	//트윗 작성
	@PostMapping(value ="/new" , consumes ="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> addTweet(@RequestBody TweetVO tweet) {
		log.info("new Tweet........" + tweet);
		
		return tweetService.add(tweet) ? new ResponseEntity<>("success", HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//트윗 전체 조회
	@GetMapping(value = "/list/{page}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<TweetVO>> getList(@PathVariable int page) {
		log.info("getTweetList........");
		return new ResponseEntity<>(tweetService.getList(new PageInfo(page, 10)), HttpStatus.OK);
		
	}
	
	
	//트윗 하나 조회
	@GetMapping(value = "/{tid}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public TweetVO getTweet(@PathVariable("tid")Long tid) {
		log.info("(getTweet........" + tid);
		
		return tweetService.get(tid);
	}
		
	//트윗 삭제
	@DeleteMapping(value="/{tid}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public String remove(@PathVariable("tid") Long tid) {
		log.info("removeTweet........" + tid);
		return tweetService.remove(tid) ? "success" : "fail" ;
	}
		
	//트윗 수정 (실무에선 걍 post쓴데)
	//ex 바꿀내용 A, B, C
	// put: 자원의 전체 수정, 자원 내 모든 필드를 전달해야 함 A, B, C 다 바꿔야 함
	// patch: 자원의 일부 수정, 수정할 필드만 전송. 특정값만 바꿔도 됨. 대신 디폴드 셋팅 해야함
	@PostMapping(value="/modify/{tid}", consumes ="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public String modify(@PathVariable Long tid, @RequestBody TweetVO tweet) {
		log.info("modifyTweet........" + tid);
		
		tweet.setTid(tid);
		return tweetService.modify(tweet) ? "success" : "fail";
	}
	
}