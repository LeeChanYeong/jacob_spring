package spring5.chap03;

/**
 * 회원정보 도메인 오브젝트. 회원 테이블과 매핑한다.
 * 
 * @author Jacob
 *
 */
public class Member {
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + "]";
	}

}
