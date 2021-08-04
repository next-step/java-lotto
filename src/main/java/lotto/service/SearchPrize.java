package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.model.LottoGame;
import lotto.model.Prize;
import lotto.validation.DuplicateNumberValidation;
import lotto.validation.EmptyCheckValidation;
import lotto.validation.LottoSizeValidation;
import lotto.validation.NumberTypeValidation;

public class SearchPrize {

	public static final String LAST_WIN_NUMBER_REGEX = ",";

	public Map<Prize, Integer> confirmWinLottoNumber(List<LottoGame> lottoGames, String lastWinNumber) {
		EmptyCheckValidation.validEmptyCheck(lastWinNumber);
		return drawWinPrize(lottoGames, getLastWinNumbers(lastWinNumber));
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

	private Map<Prize, Integer> setupWinCondition() {
		return Arrays.stream(Prize.values())
			.collect(Collectors.toMap(winnerResult -> winnerResult, winnerResult -> 0, (a, b) -> b));
	}

	public Map<Prize, Integer> drawWinPrize(List<LottoGame> lottoGames, List<Integer> lastWinNumbers) {
		Map<Prize, Integer> winPrizes = setupWinCondition();
		DuplicateNumberValidation.validDuplicateNumberCheck(lastWinNumbers);
		for (LottoGame lottoGame : lottoGames) {
			Prize winnersStatus = getLottoMatch(lastWinNumbers, lottoGame);
			winPrizes.put(winnersStatus, winPrizes.get(winnersStatus) + 1);
		}
		return winPrizes;
	}

	private Prize getLottoMatch(List<Integer> lastWinNumbers, LottoGame lottoGame) {
		return Prize.getWinnersStatus(
			getMatchLottoStatus(lottoGame.getLottoGame(), lastWinNumbers));
	}

	private int getMatchLottoStatus(List<Integer> lottoGame, List<Integer> lastWinNumbers) {
		return (int)lottoGame.stream().filter(lastWinNumbers::contains).count();
	}
}
