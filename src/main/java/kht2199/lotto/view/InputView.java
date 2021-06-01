package kht2199.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import kht2199.lotto.entity.Lotto;
import kht2199.lotto.entity.LottoList;
import kht2199.lotto.entity.LottoNumber;
import kht2199.lotto.exception.assets.AssetsException;
import kht2199.lotto.exception.assets.AssetsNegativeException;
import kht2199.lotto.exception.assets.AssetsNotEnoughException;
import kht2199.lotto.exception.input.InvalidInputError;
import kht2199.lotto.exception.input.InvalidInputException;
import kht2199.lotto.exception.number.LottoNumberLengthException;
import kht2199.lotto.exception.number.LottoNumberRangeException;

/**
 *
 * @author heetaek.kim
 */
public class InputView {

	private static final Scanner in = new Scanner(System.in);

	public int acceptAssets() throws AssetsException, InvalidInputException {
		String assetsString = in.nextLine();
		int assets = parseInt(assetsString);
		validateAssets(assets);
		return assets;
	}

	public Lotto acceptWinningNumbers() throws
			InvalidInputException,
			LottoNumberLengthException,
			LottoNumberRangeException {
		return acceptLotto();
	}

	public LottoNumber acceptBonusNumber() throws InvalidInputException, LottoNumberRangeException {
		String bonusNumberString = in.nextLine();
		validateLottoNumber(bonusNumberString);
		return LottoNumber.valueOf(bonusNumberString);
	}

	public int acceptLottoCountForManual() throws InvalidInputException {
		String manualLottoCount = in.nextLine();
		validatePositiveNumber(manualLottoCount);
		return Integer.parseInt(manualLottoCount);
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
	protected void validateLottoNumbers(String[] split) throws InvalidInputException {
		for (String s : split) {
			validateLottoNumber(s);
		}
	}

	protected void validateLottoNumber(String number) throws InvalidInputException {
		validateRange(parseInt(number));
	}

	protected void validatePositiveNumber(String number) throws InvalidInputException {
		int v = parseInt(number);
		if (v < 0) {
			throw new InvalidInputException(InvalidInputError.NEGATIVE);
		}
		if (v == 0) {
			throw new InvalidInputException(InvalidInputError.ZERO);
		}
	}

	public Lotto acceptLotto() throws InvalidInputException, LottoNumberLengthException, LottoNumberRangeException {
		String winningNumbersString = in.nextLine();
		validationLottoResultString(winningNumbersString);
		List<Integer> splitNumbers = Arrays.stream(winningNumbersString.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		return LottoNumber.valuesOf(splitNumbers, false);
	}

	private Integer parseInt(String number) throws InvalidInputException {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new InvalidInputException(InvalidInputError.PARSING, e);
		}
	}

	private void validateRange(int parseInt) throws InvalidInputException {
		if (parseInt < 1 || parseInt > 46) {
			throw new InvalidInputException(InvalidInputError.RANGE);
		}
	}

	/**
	 * Asset에 대한 검증.
	 */
	private void validateAssets(int assets) throws AssetsException {
		if (assets < 0) {
			throw new AssetsNegativeException();
		}
		if (assets < 1000) {
			throw new AssetsNotEnoughException();
		}
	}

}
