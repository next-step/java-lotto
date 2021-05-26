package kht2199.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kht2199.lotto.Lotto;
import kht2199.lotto.LottoWinningResult;
import kht2199.lotto.exception.input.InvalidInputError;
import kht2199.lotto.exception.input.InvalidInputException;

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

	public Lotto acceptWinningNumbers() {
		try {
			String winningNumbersString = in.nextLine();
			validationLottoResultString(winningNumbersString);
			String[] splitNumbers = winningNumbersString.split(",");
			List<Integer> numbers = new ArrayList<>();
			for (String splitNumber : splitNumbers) {
				numbers.add(Integer.parseInt(splitNumber));
			}
			return new Lotto(numbers);
		} catch (InvalidInputException e) {
			output.printException(e);
			return acceptWinningNumbers();
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
			checkParsableToInteger(split);
		} catch (NumberFormatException e) {
			throw new InvalidInputException(InvalidInputError.PARSING);
		}
	}

	private void checkParsableToInteger(String[] split) throws NumberFormatException {
		for (String s : split) {
			Integer.parseInt(s);
		}
	}
}
