package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static long inputPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		long purchaseAmount;
		try {
			purchaseAmount = scanner.nextLong();
			scanner.nextLine();
		} catch (Exception e) {
			throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
		}

		return purchaseAmount;
	}

	public static long inputManualCount() {
		System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
		long manualCount;
		try {
			manualCount = scanner.nextLong();
			scanner.nextLine();
		} catch (Exception e) {
			throw new IllegalArgumentException("수동으로 구매할 로또 수는 숫자만 입력 가능합니다.");
		}

		return manualCount;
	}

	public static List<String> inputManualLottos(long manualCount) {
		if (manualCount < 0) {
			throw new IllegalArgumentException("수동으로 구매할 로또 수는 양수만 가능합니다.");
		}
		System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
		List<String> inputs = new ArrayList<>();
		for (long l = 0; l < manualCount; l++) {
			inputs.add(scanner.nextLine());
		}
		return inputs;
	}

	public static String inputWinNumbers() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public static int inputBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}
}
