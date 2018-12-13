package com.springbook.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet2 extends HttpServlet{
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		process(req, resp);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String uri = request.getRequestURI();	//포트정보 다음부터
		String path = uri.substring(uri.lastIndexOf("/"));	//뒤에서 처음으로 등장하는 슬래시부터 끝까지 뽑아옴
		
		//HandlerMapping에서 실행할 Controller 추출
		Controller ctrl = handlerMapping.getController(path);
		
		//Controller 메소드 호출
		String viewName = ctrl.handleRequest(request, response);
		
		//ViewResolber에서 출력 뷰페이지 해결 do가 있으면 그냥 실행. jsp면 jsp 붙이기(HandlerMapping에서 처리)
		String view = null;
		if(!viewName.contains(".do")){
			view = viewResolver.getView(viewName);
		}
		else{
			view = viewName;
		}
		
		response.sendRedirect(view);
	}
}
