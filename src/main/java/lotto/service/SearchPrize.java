package lotto.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.WinPrizes;
import lotto.model.WinnerLotto;

public class SearchPrize {

	public static WinPrizes drawWinPrize(Lottos lottos, WinnerLotto winnerLotto) {
		Map<Prize, Integer> winPrizes = Prize.getValuesMoneySort()
			.stream()
			.collect(Collectors.toMap(prize -> prize, prize -> 0, (a, b) -> b, LinkedHashMap::new));
		for (Lotto lotto : lottos.getLottos()) {
			Prize winPrize = Prize.getWinnersStatus(
				(int)lotto.getLottoNumbers().stream().filter(winnerLotto.getWinnerLotto()::contains).count());
			winPrizes.put(winPrize, winPrizes.get(winPrize) + 1);
		}
		return new WinPrizes(winPrizes);
	}

}
