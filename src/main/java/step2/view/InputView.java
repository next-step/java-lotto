package step2.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import step2.domain.LottoNumber;
import step2.domain.LottoNumbers;

public class InputView {

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public int inputPurchasePrice() {
		final String messageOfInputPurchasePrice = "구입금액을 입력해 주세요.";

		System.out.println(messageOfInputPurchasePrice);

		int purchaseAmount = parseStringToInteger(scanner.nextLine());
		validate(purchaseAmount);

		System.out.println();

		return purchaseAmount;
	}

	public List<LottoNumbers> inputManualLottoNumbers() {
		final String messageOfManualLottoNumbers = "수동으로 구매할 번호를 입력해 주세요.";
		final String NUMBERS_DELIMITER = ", ";
		final List<LottoNumbers> lottoNumbers = new ArrayList<>();
		final List<String> numbersInputs = new ArrayList<>();
		final int manualCount = inputManualLottoCount();

		System.out.println(messageOfManualLottoNumbers);
		for (int i = 0; i < manualCount; i++) {
			numbersInputs.add(scanner.nextLine());
		}

		for (String numbersInput : numbersInputs) {
			lottoNumbers.add(new LottoNumbers(convertNumberInputSeparatedByDelimiter(numbersInput, NUMBERS_DELIMITER)));
		}
		System.out.println();

		return lottoNumbers;
	}

	private int inputManualLottoCount() {
		final String messageOfManualCount = "수동으로 구매할 로또 수를 입력해 주세요.";
		System.out.println(messageOfManualCount);
		final int manualLottoCount = parseStringToInteger(scanner.nextLine());
		System.out.println();
		return manualLottoCount;
	}

	private Set<LottoNumber> convertNumberInputSeparatedByDelimiter(final String input, final String delimiter) {
		Set<LottoNumber> numbers = new HashSet<>();
		for (String numberStr : input.split(delimiter)) {
			numbers.add(new LottoNumber(parseStringToInteger(numberStr)));
		}
		return numbers;
	}

	public LottoNumbers inputWinNumbers() {
		final String WIN_NUMBERS_DELIMITER = ", ";
		final String messageOfInputWinNumbers = "지난 주 당첨 번호를 입력해 주세요";
		Set<LottoNumber> winNumbers = new HashSet<>();

		System.out.println(messageOfInputWinNumbers);

		final String input = scanner.nextLine();
		for (String numberStr : input.split(WIN_NUMBERS_DELIMITER)) {
			winNumbers.add(new LottoNumber(parseStringToInteger(numberStr)));
		}

		System.out.println();

		return new LottoNumbers(winNumbers);
	}

	public LottoNumber inputBonusNumber() {
		final String messageOfInputBonusBall = "보너스 볼을 입력해 주세요.";
		System.out.println(messageOfInputBonusBall);
		return new LottoNumber(parseStringToInteger(scanner.nextLine()));
	}

	private Integer parseStringToInteger(final String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}
	}

	private void validate(final int purchaseAmount) {
		if (purchaseAmount < 0) {
			throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
		}
	}

}
