package org.jacob.book.example;

public class ExampleMain {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();

		// Default constructor로 생성 후 memberDao를 넣어줌
		ArticleService articleService = new ArticleService();
		articleService.setMemberDao(memberDao);

		// memberDao를 넣어주는 constructor 사용
		PaymentService paymentService = new PaymentService(memberDao);

		articleService.addArticle();
		paymentService.pay();
	}
}
