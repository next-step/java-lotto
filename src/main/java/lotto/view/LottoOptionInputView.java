package lotto.view;

import lotto.LottoOption;
import lotto.LottoStore;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoOptionInputView implements LottoOption {

	private static final Scanner SCANNER = new Scanner(System.in);

	@Override
	public int getMoney() {
		int moneyInput;
		do {
			System.out.println("구입금액을 입력해 주세요.");
			moneyInput = Integer.parseInt(SCANNER.nextLine());
		} while (!hasNoExceptionAboutMoneyValidation(moneyInput));
		return moneyInput;
	}

	private boolean hasNoExceptionAboutMoneyValidation(int moneyInput) {
		try {
			validateMoneyInput(moneyInput);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private void validateMoneyInput(int moneyInput) {
		if (moneyInput <= 0) {
			throw new IllegalArgumentException("금액은 0 초과여야합니다.");
		}

		if (moneyInput % LottoStore.LOTTO_PRICE > 0) {
			throw new IllegalArgumentException(String.format("금액은 %,d원 단위여야 합니다.", LottoStore.LOTTO_PRICE));
		}
	}

	@Override
	public WinningNumbers getWinningNumbers() {
		LottoNumbers lottoNumbers = getLottoNumbers();
		LottoNumber bonusNumber = getBonusNumber();
		return new WinningNumbers(lottoNumbers, bonusNumber);
	}

	private LottoNumbers getLottoNumbers() {
		String input;
		do {
			System.out.println("지난 주 당첨 번호를 입력해 주세요.");
			input = SCANNER.nextLine();
		} while (!hasNoExceptionForLottoNumbers(input));
		return createLottoNumbers(input);
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
		input = input.replace(" ", "");
		List<LottoNumber> lottoNumberList = Arrays.stream(input.split(","))
				.map(Integer::parseInt)
				.map(LottoNumber::new)
				.collect(Collectors.toList());
		return new LottoNumbers(lottoNumberList);
	}

	private LottoNumber getBonusNumber() {
		String input;
		do {
			System.out.println("보너스 볼을 입력해주세요.");
			input = SCANNER.nextLine();
		} while (!hasNoExceptionForBonusNumber(input));
		return new LottoNumber(Integer.parseInt(input));
	}

	private boolean hasNoExceptionForBonusNumber(String input) {
		try {
			new LottoNumber(Integer.parseInt(input));
			return true;
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주셔야 합니다.");
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
