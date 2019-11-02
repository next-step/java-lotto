package lotto.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public int receiveAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public List<Integer> receiveAnswerNumbers() {
		removeScannerBuffer();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return InputParser.parse(scanner.nextLine());
	}

	private void removeScannerBuffer() {
		scanner.nextLine();
	}

}
