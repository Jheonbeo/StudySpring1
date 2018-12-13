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
		String uri = request.getRequestURI();	//��Ʈ���� ��������
		String path = uri.substring(uri.lastIndexOf("/"));	//�ڿ��� ó������ �����ϴ� �����ú��� ������ �̾ƿ�
		
		//HandlerMapping���� ������ Controller ����
		Controller ctrl = handlerMapping.getController(path);
		
		//Controller �޼ҵ� ȣ��
		String viewName = ctrl.handleRequest(request, response);
		
		//ViewResolber���� ��� �������� �ذ� do�� ������ �׳� ����. jsp�� jsp ���̱�(HandlerMapping���� ó��)
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
