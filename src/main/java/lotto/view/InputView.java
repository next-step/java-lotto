package lotto.view;

import lotto.domain.GeneratedLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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

	public static void printLottoNumber(List<GeneratedLotto> generatedLottoNumbers) {
		for (GeneratedLotto lottoNumber : generatedLottoNumbers) {
			print(lottoNumber.toString());
		}
	}

	public static GeneratedLotto printLastPrizeInput() {
		print("지난 주 당첨 번호를 입력해 주세요.");
		String lastWeekPrizeNumber = scanner.next();
		GeneratedLotto lastWeekPrizeNumbers = validateInputPirzeNumber(lastWeekPrizeNumber);

		return lastWeekPrizeNumbers;
	}

	private static GeneratedLotto validateInputPirzeNumber(String lastWeekPrizeNumber) {
		return convertStringToInteger(lastWeekPrizeNumber);
	}

	public static GeneratedLotto convertStringToInteger(String lastWeekPrizeNumberInput) throws IllegalArgumentException {
		String[] lastWeekPrizeNumberArr = lastWeekPrizeNumberInput.split(COMMA);
		GeneratedLotto lastWeekPrizeNumberList = new GeneratedLotto(lastWeekPrizeNumberArr);

		return lastWeekPrizeNumberList;
	}

	public static void print(String message) {
		System.out.println(message);
	}

}
