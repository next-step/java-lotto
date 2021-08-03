package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.utils.Utils;
import lotto.validation.Validation;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;
	public static final String LAST_WIN_NUMBER_REGEX = ",";

	private final LottoGames lottoGames;

	public LottoPurchase(int lottoCount) {
		List<LottoGame> lottoCreateGame = IntStream.range(START_INCLUSIVE, Utils.returnThousandUnit(lottoCount))
			.mapToObj(i -> new LottoGame(LottoMachine.createLottoNumber()))
			.collect(Collectors.toList());
		lottoGames = new LottoGames(lottoCreateGame);
	}

	public LottoPurchase(LottoGames lottoGames) {
		this.lottoGames = lottoGames;
	}

	public List<LottoGame> resultLottoGame() {
		return lottoGames.getLottoGames();
	}

	public Map<Prize, Integer> confirmWinLottoNumber(String lastWinNumber) {
		Validation.validEmptyCheck(lastWinNumber);
		List<Integer> getLastWinNumbers = getLastWinNumbers(lastWinNumber);
		Map<Prize, Integer> result = setupWinCondition();
		for (LottoGame lottoGame : this.lottoGames.getLottoGames()) {
			Prize winnersStatus = Prize.getWinnersStatus(
				getMatchLottoStatus(lottoGame.getLottoGame(), getLastWinNumbers));
			int count = result.get(winnersStatus);
			result.put(winnersStatus, count + 1);
		}
		return result;
	}

	private Map<Prize, Integer> setupWinCondition() {
		return Arrays.stream(Prize.values())
			.collect(Collectors.toMap(winnerResult -> winnerResult, winnerResult -> 0, (a, b) -> b));
	}

	private int getMatchLottoStatus(List<Integer> lottoGame, List<Integer> lastWinNumbers) {
		return (int)lottoGame.stream().filter(lastWinNumbers::contains).count();
	}

	private List<Integer> getLastWinNumbers(String lastWinNumber) {
		Validation.validLottoSizeCheck(lastWinNumber.split(LAST_WIN_NUMBER_REGEX));
		return Arrays.stream(lastWinNumber.split(LAST_WIN_NUMBER_REGEX))
			.map(this::toInt)
			.collect(Collectors.toList());
	}

	private Integer toInt(String s) {
		Validation.validNumberTypeCheck(s);
		return Integer.parseInt(s);
	}
}
