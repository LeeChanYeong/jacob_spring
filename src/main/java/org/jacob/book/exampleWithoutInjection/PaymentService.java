package org.jacob.book.exampleWithoutInjection;

public class PaymentService {
	MemberDao memberDao = null;

	public PaymentService() {
		// memberDao를 만들어서 초기화
		this.memberDao = new MemberDao();
	}

	public void pay() {
		memberDao.getMember();
		System.out.println("지급이 완료되었습니다.");
	}
}
