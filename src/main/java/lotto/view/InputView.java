package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;

import java.util.*;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	private static final String COMMA = ",";

	public static int printInputNoticeForPurchaseAmount() {
		print("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static int printInputManualLottoCount() {
		print("수동으로 구매할 로또 수를 입력해 주세요.");
		return scanner.nextInt();
	}

	public static LottoList printInputManualLotto(int manualLottoCount) {
		print("수동으로 구매할 번호를 입력해 주세요.");
		LottoList lottoList = new LottoList();
		for (int i = 0; i < manualLottoCount; i++) {
			String manualInput = scanner.next();
			Lotto manualLotto = validateInputPirzeNumber(manualInput);
			lottoList.add(manualLotto);
		}
		return lottoList;
	}

	public static void printPurchaseLottoCount(int autoLottoCount, int manualLottoCount) {
		print(String.format("수동으로 %d장, 자동으로 %d를 구매했습니다.", manualLottoCount, autoLottoCount));
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

	public static void printPurchaseLottoNumber(LottoList purchargedLottos) {
		for(Lotto lotto : purchargedLottos.getLottosList()){
			System.out.println(lotto.toString());
		}

	}
}
