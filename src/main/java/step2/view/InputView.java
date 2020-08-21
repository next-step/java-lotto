package step2.view;

import step2.domain.Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {}

	public static int inputPrice() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static Lotto inputWinningNumbers() {
		scanner.nextLine();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String[] inputValue = scanner.nextLine().split(", ");
		return new Lotto(
				Arrays.stream(inputValue)
						.map(Integer::new)
						.collect(Collectors.toList())
		);
	}

	public static int inputBonusBall() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}
}
