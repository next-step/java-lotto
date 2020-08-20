package lotto.input;

import java.util.Scanner;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public static String inputPurchase() {
		System.out.println("구입금액을 입력해 주세요.");
		return SCANNER.nextLine();
	}

	public static String inputWinning() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return SCANNER.nextLine();
	}
}
