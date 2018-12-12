package polymorphism;
//지연 로딩 방식 : 클라이언트의 요청에 의해서만 객체 생성
public class BeanFactory {
	public Object getBean(String beanName) {
		TV tv = null;
		if(beanName.equals("samsung")) {
			tv = new SamsungTV();
		}
		else if(beanName.equals("lg")){
			tv = new LgTV();
		}
		return tv;
	}
}
