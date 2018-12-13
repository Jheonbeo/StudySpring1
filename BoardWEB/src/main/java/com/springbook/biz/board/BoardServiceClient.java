	package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardSerivce = (BoardService)container.getBean("boardSerivce"); //getBean은 무조건 object로 반환
		
		//vo 객체는 presentation -> biz -> persist 3Layer 모두 왔다갔다 해서 data transfer object의 의미인것 DTO 
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용..");
		boardSerivce.insertBoard(vo);
		
		List<BoardVO> boardList = boardSerivce.getBoardList(vo);
		for(BoardVO board : boardList){
			System.out.println("---> " + board.toString());
		}
		container.close();
	}

}
