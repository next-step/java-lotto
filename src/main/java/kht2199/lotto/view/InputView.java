package kht2199.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import kht2199.lotto.LottoNumber;
import kht2199.lotto.LottoNumbers;
import kht2199.lotto.LottoWinningResult;
import kht2199.lotto.exception.LottoBonusNumberDuplicatedException;
import kht2199.lotto.exception.LottoWinningNumberNotInitiatedException;
import kht2199.lotto.exception.input.InvalidInputError;
import kht2199.lotto.exception.input.InvalidInputException;
import kht2199.lotto.exception.number.LottoNumberException;
import kht2199.lotto.exception.number.LottoNumberRangeException;

/**
 *
 * @author heetaek.kim
 */
public class InputView {

	private static final Scanner in = new Scanner(System.in);

	private final ResultView output;

	public InputView(ResultView output) {
		this.output = output;
	}

	public int assets() {
		String assetsString = in.nextLine();
		return Integer.parseInt(assetsString);
	}

	public void acceptWinningNumbers(LottoWinningResult winningNumbers) {
		try {
			String winningNumbersString = in.nextLine();
			validationLottoResultString(winningNumbersString);
			List<Integer> splitNumbers = Arrays.stream(winningNumbersString.split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
			LottoNumbers lottoNumbers = LottoNumber.valuesOf(splitNumbers);
			winningNumbers.setWinningNumbers(lottoNumbers);
		} catch (InvalidInputException | LottoNumberException e) {
			output.printException(e);
			acceptWinningNumbers(winningNumbers);
		} catch (NumberFormatException e) {
			output.printException(e);
			acceptWinningNumbers(winningNumbers);
		}
	}

	public void acceptBonusNumber(LottoWinningResult winningNumbers) {
		try {
			String bonusNumberString = in.nextLine();
			validateLottoNumber(bonusNumberString);
			winningNumbers.setBonusNumber(LottoNumber.valueOf(bonusNumberString));
		} catch (InvalidInputException | LottoBonusNumberDuplicatedException |
				LottoWinningNumberNotInitiatedException | LottoNumberRangeException e) {
			output.printException(e);
			acceptBonusNumber(winningNumbers);
		} catch (NumberFormatException e) {
			output.printException(e);
			acceptBonusNumber(winningNumbers);
		}
	}

	/**
	 * 입력 문자열 자체에 대한 검증은 UI에서 검증.
	 */
	protected void validationLottoResultString(String input) throws InvalidInputException {
		if (input == null || input.equals("")) {
			throw new InvalidInputException(InvalidInputError.EMPTY);
		}
		String[] split = input.split(",");
		if (split.length != 6) {
			throw new InvalidInputException(InvalidInputError.LENGTH);
		}
		try {
			validateLottoNumbers(split);
		} catch (NumberFormatException e) {
			throw new InvalidInputException(InvalidInputError.PARSING);
		}
	}

	/**
	 * 번호 유효성 체크
	 */
	protected void validateLottoNumbers(String[] split)
			throws NumberFormatException, InvalidInputException {
		for (String s : split) {
			validateLottoNumber(s);
		}
	}

	protected void validateLottoNumber(String number)
			throws NumberFormatException, InvalidInputException {
		validateRange(Integer.parseInt(number));
	}

	private void validateRange(int parseInt) throws InvalidInputException {
		if (parseInt < 1 || parseInt > 46) {
			throw new InvalidInputException(InvalidInputError.RANGE);
		}
	}
}
