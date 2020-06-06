package lotto.view;

import java.util.Scanner;

import lotto.collections.Money;
import lotto.collections.WinningNumbers;
import lotto.domain.LottoNumber;
import lotto.service.WinningService;

public class InputView {

	public static final Scanner scanner = new Scanner(System.in);

	public static Money inputPurchaseMoney() {
		System.out.println("NextStep 로또게임에 오신 것을 환영합니다!");
		System.out.println("구매금액을 입력해 주세요.");
		return new Money(scanner.nextInt());
	}

	public static int inputManuallyDrawnTickets() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return scanner.nextInt();
	}

	public static LottoNumber inputBonusBall() {
		System.out.println("보너스 볼을 입력해주세요.");
		return new LottoNumber(scanner.nextInt());
	}

	public static WinningNumbers inputLastWeekWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String winningNumber = scanner.next();
		return WinningService.createWinningNumbers(winningNumber);
	}

}
