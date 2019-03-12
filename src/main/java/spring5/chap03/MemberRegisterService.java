package spring5.chap03;

/**
 * 회원을 등록하는 서비스
 * 
 * @author Jacob
 */
public class MemberRegisterService {

	private MemberDao memberDao;

	/**
	 * Dependency Injection (DI)을 위한 setter method
	 */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	/**
	 * 이메일로 회원등록
	 */
	public void regist(Member member) {
		Member m2 = memberDao.selectByEmail(member.getEmail());
		System.out.println(m2);

		if (m2 == null) {// 데이터베이스에 동일한 email의 멤버가 없으면 새로 저장
			memberDao.insert(member);
			System.out.println("회원정보를 저장했습니다.");
		} else {
			System.out.println("회원정보를 저장하지 않았습니다.");
		}

	}
}
