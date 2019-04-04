package org.jacob.book.example;

public class PaymentService {
	MemberDao memberDao;

	// constructor for memberDao injection
	public PaymentService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void pay() {
		memberDao.getMember();
		System.out.println("지급이 완료되었습니다.");
	}
}
