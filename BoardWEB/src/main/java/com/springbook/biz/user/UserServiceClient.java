package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userSerivce = (UserService)container.getBean("userSerivce"); //getBean은 무조건 object로 반환
		
		//vo 객체는 presentation -> biz -> persist 3Layer 모두 왔다갔다 해서 data transfer object의 의미인것 DTO 
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userSerivce.getUser(vo);
		if(user != null){
			System.out.println(user.getName() + "님 환영합니다.");
		}
		else{
			 System.out.println("로그인 실패");
		}
		container.close();
	}

}
