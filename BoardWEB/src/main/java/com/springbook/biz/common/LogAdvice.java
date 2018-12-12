package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){}	//해당 함수는 xml에서 ID라 보면 됨 
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut(){}	//해당 함수는 xml에서 ID라 보면 됨 
	
	@Before("allPointcut()")
	public void printLog(){
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}
