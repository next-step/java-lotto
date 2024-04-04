package lotto.io;

import lotto.domain.strategy.ManualLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputPurchasePrice() {
		System.out.println("구매금액을 입력해주세요");
		return Integer.parseInt(scanner.nextLine());
	}

	public static int inputNumberOfManualLotto() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public static String[] inputWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine().replace(" ", "").split(",");
	}

	public static int inputBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public static String[] inputLottoNumber() {
		return scanner.nextLine().replace(" ", "").split(",");
	}
}
