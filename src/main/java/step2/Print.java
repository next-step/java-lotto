package step2;

import java.util.Set;

public class Print {
	public static void inputAmount() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public static void amount(int input) {
		System.out.println(input + "개를 구매했습니다.");
	}

	public static void result(Set<Integer> result) {
		System.out.println(result);
	}
}
