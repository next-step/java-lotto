package lotto.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner in = new Scanner(System.in);

	public static String askToUserPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return in.nextLine();
	}

	public static String askToUserPurchaseNumberOfManual() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return in.nextLine();
	}

	public static void printPleaseInputManuallyNumber() {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
	}

	public static String enterPurchaseManuallyNumber() {
		return in.nextLine();
	}

	public static String askToUserLastWeekWinnerNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return in.nextLine();
	}

	public static String askToUserBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return in.nextLine();
	}

}
