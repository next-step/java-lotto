package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.dto.PurchaseInfo;
import lotto.dto.WinningNumber;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static PurchaseInfo buyLotto() {
		System.out.println("구입금액을 입력해 주세요.");
		int money = scanner.nextInt();

		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		int manualPickCount = scanner.nextInt();
		scanner.nextLine(); // 엔터 제거

		List<String> manualNumbers = new ArrayList<>();
		if(hasManualPickCount(manualPickCount)) {
			System.out.println("수동으로 구매할 번호를 입력해 주세요.");
			manualNumbers.addAll(inputManualNumbers(manualPickCount));
		}

		return new PurchaseInfo(new Money(money), manualNumbers);
	}

	private static boolean hasManualPickCount(int manualPickCount) {
		return manualPickCount > 0;
	}

	private static List<String> inputManualNumbers(int manualPickCount) {
		List<String> manualNumbers = new ArrayList<>();
		for(int count = 1; count <= manualPickCount; count++) {
			String manualNumber = scanner.nextLine();
			manualNumbers.add(manualNumber);
		}
		return manualNumbers;
	}

	public static WinningNumber drawWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String winningNumber = scanner.nextLine();

		System.out.println("보너스 볼을 입력해 주세요.");
		Integer bonusNumber = scanner.nextInt();

		return new WinningNumber(winningNumber, new LottoNumber(bonusNumber));
	}
}
