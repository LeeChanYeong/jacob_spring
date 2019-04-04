package org.jacob.book.chap03;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MemberRegisterService를 테스트한다.<br>
 * Spring ApplicationContext로 빈을 생성한다.
 * 
 * @author Jacob
 */
public class MemberMainUsingSpring {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				"chap03.xml");
		MemberRegisterService regService = ctx.getBean("memberRegisterService",
				MemberRegisterService.class);

		// registerRequest 초기화
		RegisterRequest req = new RegisterRequest();
		req.setEmail("jacob@irafe.com");
		req.setPassword("xxxx");
		req.setName("Jacob");

		// 회원 등록
		regService.regist(req);
		ctx.close();
	}
}
