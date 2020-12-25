package lotto.view;

import lotto.domain.Lotto;

import java.util.*;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	private static final String COMMA = ",";

	public static int printInputNoticeForPurchaseAmount() {
		print("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static void printPurchaseLottoCount(int lottoTryCount) {
		print(String.format("%d개를 구매했습니다.", lottoTryCount));
	}

	public static Lotto printLastPrizeInput() {
		print("지난 주 당첨 번호를 입력해 주세요.");
		String lastWeekPrizeNumber = scanner.next();
		return validateInputPirzeNumber(lastWeekPrizeNumber);
	}

	public static int printBonusNumberInput() {
		print("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}

	private static Lotto validateInputPirzeNumber(String lastWeekPrizeNumber) {
		return convertStringToInteger(lastWeekPrizeNumber);
	}

	public static Lotto convertStringToInteger(String lastWeekPrizeNumberInput) {
		String[] lastWeekPrizeNumberArr = lastWeekPrizeNumberInput.split(COMMA);
		List<Integer> lastWeekPrizeNumber = new ArrayList<>();
		for (String number : lastWeekPrizeNumberArr) {
			lastWeekPrizeNumber.add(Integer.parseInt(number.trim()));
		}
		return new Lotto(lastWeekPrizeNumber);
	}

	public static void print(String message) {
		System.out.println(message);
	}

	public static void printPurchaseLottoNumber(List<Lotto> purchargedLottos) {
		for(Lotto lotto : purchargedLottos){
			System.out.println(lotto.toString());
		}

	}
}
