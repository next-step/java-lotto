package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.WinningNumber;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String DELIMITER_COMMA = ",";

	public static long scanPayment() {
		System.out.println("구매금액을 입력해 주세요.");
		String payment = scanner.nextLine();
		return Long.parseLong(payment);
	}

	public static WinningNumber scanWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String inputNumbers = scanner.nextLine();
		LottoNumber winningNumbers = toLottoNumber(inputNumbers);

		System.out.println("보너스 볼을 입력해 주세요.");
		int bonusNumber = scanner.nextInt();
		return new WinningNumber(winningNumbers, bonusNumber);
	}

	public static int scanManualNumberSize() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		String manualSize = scanner.nextLine();
		return Integer.parseInt(manualSize);
	}

	public static ManualLottoNumbers scanManualNumbers(int manualSize) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < manualSize; i ++) {
			String inputNumbers = scanner.nextLine();
			lottoNumbers.add(toLottoNumber(inputNumbers));
		}
		return new ManualLottoNumbers(lottoNumbers);
	}

	private static LottoNumber toLottoNumber(String inputNumbers) {
		List<Integer> numbers = Arrays.stream(inputNumbers.replaceAll(" ", "").split(DELIMITER_COMMA))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		return new LottoNumber(numbers);
	}
}
