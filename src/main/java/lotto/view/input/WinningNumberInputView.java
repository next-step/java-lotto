package lotto.view.input;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;

import java.util.Scanner;

public class WinningNumberInputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private final LottoNumbersInputView lottoNumbersInputView;

	public WinningNumberInputView() {
		this.lottoNumbersInputView = LottoNumbersInputView.getInstance();
	}

	public WinningNumbers getWinningNumbers() {
		LottoNumbers lottoNumbers = lottoNumbersInputView.inputLottoNumbers("지난 주 당첨 번호를 입력해 주세요.");
		LottoNumber bonusNumber = getBonusNumber();
		return new WinningNumbers(lottoNumbers, bonusNumber);
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
