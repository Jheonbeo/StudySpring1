package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardSerivce")
public class BoardSeriveImpl implements BoardService {
	@Autowired
	private BoardDAOSpring2 boardDAO;
	
	public BoardSeriveImpl() {
	}

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		/*if(vo.getSeq()==0){
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		}*/
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(vo);
	}

	@Override
	public void getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList(vo);
	}

}
