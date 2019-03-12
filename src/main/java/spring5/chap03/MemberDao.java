package spring5.chap03;

/**
 * 회원 테이블을 조작하는 Data Access Object
 * 
 * @author Jacob
 */
public class MemberDao {
	/**
	 * 회원 테이블에서 이메일로 회원정보를 가져온다.
	 * 
	 * @param email 이메일
	 * @return 회원정보
	 */
	public Member selectByEmail(String email) {
		// TODO: 데이터베이스에서 이메일로 회원정보를 가져온다.
		return null;
	}

	/**
	 * 회원 테이블에 회원정보를 저장한다.
	 * 
	 * @param member 회원정보
	 */
	public void insert(Member member) {
		// TODO: 데이터베이스에 회원정보를 저장한다.
	}
}
