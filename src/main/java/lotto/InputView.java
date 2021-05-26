package lotto;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static Money pay() {
		System.out.println("구입금액을 입력해 주세요.");
		return new Money(scanner.nextInt());
	}

	public static Lotto winLotto() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String text = scanner.next();
		return new Lotto(text);
	}

	public static LottoNumber bonusBall() {
		System.out.println("보너스 볼을 입력해 주세요.");
		int bonusBall = scanner.nextInt();
		return LottoNumber.valueOf(bonusBall);
	}
}
