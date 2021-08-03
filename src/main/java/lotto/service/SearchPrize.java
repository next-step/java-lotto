package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.model.LottoGame;
import lotto.model.LottoGames;
import lotto.model.Prize;

public class SearchPrize {

	private final Map<Prize, Integer> winPrizes;

	public SearchPrize() {
		this.winPrizes = setupWinCondition();
	}

	private Map<Prize, Integer> setupWinCondition() {
		return Arrays.stream(Prize.values())
			.collect(Collectors.toMap(winnerResult -> winnerResult, winnerResult -> 0, (a, b) -> b));
	}

	public Map<Prize, Integer> getWinPrizes(LottoGames lottoGames, List<Integer> lastWinNumbers) {
		for (LottoGame lottoGame : lottoGames.getLottoGames()) {
			Prize winnersStatus = Prize.getWinnersStatus(
				getMatchLottoStatus(lottoGame.getLottoGame(), lastWinNumbers));
			int count = winPrizes.get(winnersStatus);
			winPrizes.put(winnersStatus, count + 1);
		}
		return winPrizes;
	}

	private int getMatchLottoStatus(List<Integer> lottoGame, List<Integer> lastWinNumbers) {
		return (int)lottoGame.stream().filter(lastWinNumbers::contains).count();
	}
}
