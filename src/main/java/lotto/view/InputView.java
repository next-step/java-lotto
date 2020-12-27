package lotto.view;

import lotto.domain.*;
import lotto.domain.input.LottoBuyCount;
import lotto.domain.input.Money;

import java.util.*;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	private static final String COMMA = ",";

	public static Money printInputNoticeForPurchaseAmount() {
		print("구입금액을 입력해 주세요.");
		return new Money(scanner.nextInt());
	}

	public static LottoBuyCount printInputManualLottoCount() {
		print("수동으로 구매할 로또 수를 입력해 주세요.");
		return new LottoBuyCount(scanner.nextInt());
	}

	public static LottoList printInputManualLotto(LottoBuyCount manualLottoCount) {
		print("수동으로 구매할 번호를 입력해 주세요.");
		LottoList lottoList = new LottoList();
		for (int i = 0; i < manualLottoCount.getLottoBuyCount(); i++) {
			String manualInput = scanner.next();
			Lotto manualLotto = validateInputPirzeNumber(manualInput);
			lottoList.add(manualLotto);
		}
		return lottoList;
	}

	public static void printPurchaseLottoCount(LottoBuyCount autoLottoCount, LottoBuyCount manualLottoCount) {
		print(String.format("수동으로 %d장, 자동으로 %d를 구매했습니다.", manualLottoCount.getLottoBuyCount(), autoLottoCount.getLottoBuyCount()));
	}

	public static Lotto printLastPrizeInput() {
		print("지난 주 당첨 번호를 입력해 주세요.");
		String lastWeekPrizeNumber = scanner.next();
		return validateInputPirzeNumber(lastWeekPrizeNumber);
	}

	public static LottoNumber printBonusNumberInput() {
		print("보너스 볼을 입력해 주세요.");
		return new LottoNumber(scanner.nextInt());
	}

	private static Lotto validateInputPirzeNumber(String lastWeekPrizeNumber) {
		return convertStringToInteger(lastWeekPrizeNumber);
	}

	public static Lotto convertStringToInteger(String lastWeekPrizeNumberInput) {
		String[] lastWeekPrizeNumberArr = lastWeekPrizeNumberInput.split(COMMA);
		List<LottoNumber> lastWeekPrizeNumber = new ArrayList<>();
		for (String number : lastWeekPrizeNumberArr) {
			lastWeekPrizeNumber.add(new LottoNumber(Integer.parseInt(number.trim())));
		}
		return new Lotto(lastWeekPrizeNumber);
	}

	public static void print(String message) {
		System.out.println(message);
	}

	public static void printPurchaseLottoNumber(LottoList purchargedLottos) {
		for(Lotto lotto : purchargedLottos.getLottoList()){
			System.out.println(lotto.toString());
		}

	}
}
