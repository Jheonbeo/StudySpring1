package polymorphism;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import polymorphism.TV;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Spring �����̳� �����Ѵ�.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		//BeanFactory factory = new BeanFactory();
		
		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup) �Ѵ�.
		TV tv = (TV)factory.getBean("samTV");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring �����̳ʸ� �����Ѵ�.
		factory.close();
	}

}
