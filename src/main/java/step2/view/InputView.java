package step2.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String SEPARATOR = ", ";

	public int getPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return SCANNER.nextInt();
	}

	public List<Integer> getWinningNumber() {
		SCANNER.nextLine();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return splitInput(SCANNER.nextLine(), SEPARATOR);
	}

	public List<Integer> splitInput(String input, String separator) {
		return Stream.of(input.split(separator))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
