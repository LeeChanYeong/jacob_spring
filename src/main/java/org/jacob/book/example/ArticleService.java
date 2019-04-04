package org.jacob.book.example;

public class ArticleService {

	MemberDao memberDao;

	// memberDao setter for injection
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void addArticle() {
		memberDao.getMember();
		System.out.println("글을 등록했습니다.");
	}
}
