package spring5.chap03;

public class MemberMain {

	public static void main(String[] args) {
		MemberRegisterService service = new MemberRegisterService();
		Member member = new Member();
		member.setEmail("jacob@irafe.com");
		service.regist(member);
	}
}
