package lotto.view.input;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class LottoNumbersInputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	private static LottoNumbersInputView instance;

	static LottoNumbersInputView getInstance() {
		if (instance == null) {
			instance = new LottoNumbersInputView();
		}
		return instance;
	}

	private LottoNumbersInputView() {
	}

	LottoNumbers inputLottoNumbers(String guideMessage) {
		String input;
		do {
			printMessage(guideMessage);
			input = SCANNER.nextLine();
		} while (!hasNoExceptionForLottoNumbers(input));
		return createLottoNumbers(input);
	}

	private void printMessage(String message) {
		if (message != null && !message.trim().isEmpty()) {
			System.out.println(message);
		}
	}

	private boolean hasNoExceptionForLottoNumbers(String input) {
		try {
			createLottoNumbers(input);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private LottoNumbers createLottoNumbers(String input) {
		List<LottoNumber> lottoNumberList = Arrays.stream(input.split(","))
				.map(String::trim)
				.map(Integer::parseInt)
				.map(LottoNumber::new)
				.collect(Collectors.toList());
		return new LottoNumbers(lottoNumberList);
	}
}
