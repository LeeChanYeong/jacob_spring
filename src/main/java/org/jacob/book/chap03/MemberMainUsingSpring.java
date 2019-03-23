package org.jacob.book.chap03;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMainUsingSpring {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				"chap03.xml");
		MemberRegisterService service = ctx.getBean("memberRegisterService",
				MemberRegisterService.class);
		Member member = new Member();
		member.setEmail("jacob@irafe.com");
		service.regist(member);
		ctx.close();
	}
}
