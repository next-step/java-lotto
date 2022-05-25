package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Amount;
import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;

public class InputView {

	private InputView() {}

	public static final Scanner scanner = new Scanner(System.in);

	public static String inputPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextLine();
	}

	public static String inputPurchaseManualQuantity() {
		System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
		return scanner.nextLine();
	}

	public static List<String> inputPurchaseManualNumbers(int quantity) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");

		return IntStream.rangeClosed(1, quantity)
			.mapToObj(n -> scanner.nextLine())
			.collect(Collectors.toList());
	}

	public static String inputWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public static String inputBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextLine();
	}
}
