package lotto.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static int receiveAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static List<Integer> receiveAnswerNumbers() {
		removeScannerBuffer();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return InputParser.parse(scanner.nextLine());
	}

	private static void removeScannerBuffer() {
		scanner.nextLine();
	}

	public static int receiveBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}

}
