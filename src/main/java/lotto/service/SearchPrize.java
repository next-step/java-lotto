package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinPrizes;

public class SearchPrize {

	public static WinPrizes drawWinPrize(List<Lotto> lotteries, List<Integer> lastWinNumbers) {
		Map<Prize, Integer> winPrizes = Arrays.stream(Prize.values())
			.collect(Collectors.toMap(winnerResult -> winnerResult, winnerResult -> 0, (a, b) -> b));
		for (Lotto lotto : lotteries) {
			Prize winnersStatus = Prize.getWinnersStatus(
				(int)lotto.getLotto().stream().filter(lastWinNumbers::contains).count());
			winPrizes.put(winnersStatus, winPrizes.get(winnersStatus) + 1);
		}
		return new WinPrizes(winPrizes);
	}

}
