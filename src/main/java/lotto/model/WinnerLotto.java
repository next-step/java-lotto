package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.message.ErrorMessage;

public class WinnerLotto {

	private static final String LAST_WIN_NUMBER_REGEX = ",";
	private static final String INT_REG_EXP = "^\\d+$";
	private static final int LOTTO_NUMBER_LENGTH = 6;

	private final List<Integer> winnerNumbers;

	public WinnerLotto(String winnerNumbers) {
		checkLottoEmpty(winnerNumbers);
		this.winnerNumbers = Collections.unmodifiableList(toList(winnerNumbers));
	}

	private List<Integer> toList(String winnerNumbers) {
		List<Integer> lottoNumbers = Arrays.stream(winnerNumbers.split(LAST_WIN_NUMBER_REGEX))
			.map(this::toInt)
			.collect(Collectors.toList());
		checkLottoSize(lottoNumbers);
		checkDuplicateNumber(lottoNumbers);
		return lottoNumbers;
	}

	private int toInt(String winnerNumbers) {
		checkNumberType(winnerNumbers.trim());
		return Integer.parseInt(winnerNumbers.trim());
	}

	public List<Integer> getWinnerLotto() {
		return winnerNumbers;
	}

	private static void checkLottoEmpty(String lotto) {
		if (lotto.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	private static void checkNumberType(String lottoNumber) {
		if (!lottoNumber.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	private static void checkLottoSize(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE);
		}
	}

	private static void checkDuplicateNumber(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE);
		}
	}
}
