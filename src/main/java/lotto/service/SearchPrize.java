package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinPrizes;
import lotto.validation.DuplicateNumberValidation;
import lotto.validation.EmptyCheckValidation;
import lotto.validation.LottoSizeValidation;
import lotto.validation.NumberTypeValidation;

public class SearchPrize {

	public static final String LAST_WIN_NUMBER_REGEX = ",";

	public WinPrizes confirmWinLottoNumber(List<Lotto> lottoGame, String lastWinNumber) {
		EmptyCheckValidation.validEmptyCheck(lastWinNumber);
		return drawWinPrize(lottoGame, getLastWinNumbers(lastWinNumber));
	}

	private List<Integer> getLastWinNumbers(String lastWinNumber) {
		String[] lastWinNumbers = lastWinNumber.split(LAST_WIN_NUMBER_REGEX);
		LottoSizeValidation.validLottoSizeCheck(lastWinNumbers);
		return Arrays.stream(lastWinNumbers)
			.map(this::toInt)
			.collect(Collectors.toList());
	}

	private Integer toInt(String value) {
		NumberTypeValidation.validNumberTypeCheck(value.trim());
		return Integer.parseInt(value.trim());
	}

	public WinPrizes drawWinPrize(List<Lotto> lottoGame, List<Integer> lastWinNumbers) {
		Map<Prize, Integer> winPrizes = setupWinCondition();
		DuplicateNumberValidation.validDuplicateNumberCheck(lastWinNumbers);
		for (Lotto lotto : lottoGame) {
			Prize winnersStatus = getLottoMatch(lastWinNumbers, lotto);
			winPrizes.put(winnersStatus, winPrizes.get(winnersStatus) + 1);
		}
		return new WinPrizes(winPrizes);
	}

	private Map<Prize, Integer> setupWinCondition() {
		return Arrays.stream(Prize.values())
			.collect(Collectors.toMap(winnerResult -> winnerResult, winnerResult -> 0, (a, b) -> b));
	}

	private Prize getLottoMatch(List<Integer> lastWinNumbers, Lotto lotto) {
		return Prize.getWinnersStatus(
			getMatchLottoStatus(lotto.getLotto(), lastWinNumbers));
	}

	private int getMatchLottoStatus(List<Integer> lottoGame, List<Integer> lastWinNumbers) {
		return (int)lottoGame.stream().filter(lastWinNumbers::contains).count();
	}
}
