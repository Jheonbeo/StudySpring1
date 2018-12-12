package polymorphism;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import polymorphism.Speaker;

@Component("samTV")	//bean대신 어노테이션 설정으로 주입
public class SamsungTV implements TV{
	@Resource(name="apple")
	private Speaker speaker;
	private int price;
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리..");
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}

	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...(자원해체 작업)");
	}
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체(1) 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		super();
		System.out.println("===> SamsungTV 객체(2) 생성");
		this.speaker = speaker;
	}

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV 객체(3) 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV--전원 켠다. (가격 : " + price + ")");
	}
	
	public void powerOff(){
		System.out.println("SamsungTV--전원 끈다.");
	}
	
	public void volumeUp(){
		speaker.volumeUp();
	}
	
	public void volumeDown(){
		speaker.volumeDown();
	}
}
