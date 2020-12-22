package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.WinLotto;

public class InputView {
	private static final String DELIMITER = ",";

	private static final Scanner scanner = new Scanner(System.in);

	public static int inputByMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static WinLotto inputWinLottoNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		scanner.skip("[\r\n]+");
		String input = scanner.nextLine();
		List<Integer> winLotto = Arrays.stream(input.split(DELIMITER))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		System.out.println("보너스 볼을 입력해 주세요.");
		int bonus = scanner.nextInt();
		return new WinLotto(winLotto, bonus);
	}
}
