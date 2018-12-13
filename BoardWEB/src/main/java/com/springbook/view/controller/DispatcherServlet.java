package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

//Front Controller
public class DispatcherServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Get방식으로 요청시 호출
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	//Post방식으로 요청시 호출
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("euc-kr");
		process(req, resp);
	}
	//Post Get 둘다 상관없으면 Serivce로 함수로 처리
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		if(path.equals("/login.do")){
			System.out.println("로그인 처리");
			String id = request.getParameter("id");
			String pwd = request.getParameter("password");
			
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(pwd);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			if(user != null){
				response.sendRedirect("getBoardList.do");
			}
			else{
				response.sendRedirect("login.jsp");
			}
		}
		else if(path.equals("/logout.do")){
			System.out.println("로그아웃 처리");
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		else if(path.equals("/insertBoard.do")){
			System.out.println("글 등록 처리");
			request.setCharacterEncoding("euc-kr");

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			response.sendRedirect("getBoardList.jsp");
		}
		else if(path.equals("/updateBoard.do")){
			System.out.println("글 수정 처리");
			request.setCharacterEncoding("euc-kr");
			String seq = request.getParameter("seq");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			vo.setTitle(title);
			vo.setContent(content);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		}
		else if(path.equals("/deleteBoard.do")){
			System.out.println("글 삭제 처리");
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);

			response.sendRedirect("getBoardList.do");
		}
		else if(path.equals("/getBoard.do")){
			System.out.println("글 상세 조회 처리");
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			HttpSession session = request.getSession();
			session.setAttribute("board", board);	//서버단 session부근에 boardList 저장
			response.sendRedirect("getBoard.jsp");
		}
		else if(path.equals("/getBoardList.do")){
			System.out.println("글 목록 검색 처리");
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);	//서버단 session부근에 boardList 저장
			response.sendRedirect("getBoardList.jsp");
		}
	}
}
//HttpServletRequest, HttpServletResponse -요청이 들어올 때마다 매번 만들어짐(클라이언트에서 요청). 함수 동작이 종료되면 삭제됨. doget, dopost, service등
//HttpSession -client 접속시(request.getSession()), client 종료시(웹브라우저 종료시, invalidate(), 유효시간 경과), 로그인/아웃/장바구니 기능등에 쓰이지
//ServletContext -서버 시작시, 서버 종료시, Web application
//저장 : setAttribute(name, value)
//추출 : getAttribute(name)
//삭제 : removeAttribute(name)
