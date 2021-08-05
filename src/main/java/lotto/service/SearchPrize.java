package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinPrizes;
import lotto.utils.ErrorMessage;

public class SearchPrize {

	private static final String LAST_WIN_NUMBER_REGEX = ",";
	private static final String INT_REG_EXP = "^\\d+$";
	private static final int LOTTO_LENGTH = 6;

	public static WinPrizes confirmWinLottoNumber(List<Lotto> lottoGame, String lastWinNumber) {
		validEmptyCheck(lastWinNumber);
		String[] lastWinNumbers = lastWinNumber.split(LAST_WIN_NUMBER_REGEX);
		validLottoSizeCheck(lastWinNumbers);
		List<Integer> lottoNumbers = new ArrayList<>();
		for (String lottoNumber : lastWinNumbers) {
			validNumberTypeCheck(lottoNumber.trim());
			Integer integer = Integer.parseInt(lottoNumber.trim());
			lottoNumbers.add(integer);
		}
		validDuplicateNumberCheck(lottoNumbers);
		return drawWinPrize(lottoGame, lottoNumbers);
	}

	private static WinPrizes drawWinPrize(List<Lotto> lottoGame, List<Integer> lastWinNumbers) {
		Map<Prize, Integer> winPrizes = Arrays.stream(Prize.values())
			.collect(Collectors.toMap(winnerResult -> winnerResult, winnerResult -> 0, (a, b) -> b));
		for (Lotto lotto : lottoGame) {
			Prize winnersStatus = Prize.getWinnersStatus(
				(int)lotto.getLotto().stream().filter(lastWinNumbers::contains).count());
			winPrizes.put(winnersStatus, winPrizes.get(winnersStatus) + 1);
		}
		return new WinPrizes(winPrizes);
	}

	private static void validLottoSizeCheck(String[] value) {
		if (value.length != LOTTO_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE);
		}
	}

	private static void validEmptyCheck(String lastWinNumber) {
		if (lastWinNumber.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	private static void validNumberTypeCheck(String value) {
		if (!value.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	private static void validDuplicateNumberCheck(List<Integer> values) {
		if (values.size() != values.stream().distinct().count()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE);
		}
	}

}
