package org.jacob.book.chap02;

/**
 * Greeter 인스턴스를 직접 생성하는 Main
 *
 * @author Jacob
 */
public class NormalMain {

	public static void main(String[] args) {
		// greeter 오브젝트 생성
		Greeter g1 = new Greeter();
		g1.greet();

		// greeter 오브젝트 생성
		Greeter g2 = new Greeter();
		g2.greet();
	}

}
