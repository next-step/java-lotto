package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lotto.utils.PrizeComparator;

public class WinPrizes {

	private final Map<Prize, Integer> winPrizes;

	public WinPrizes(Map<Prize, Integer> winPrizes) {
		this.winPrizes = winPrizes;
	}

	public int searchWinPrizeGrade(Prize prize) {
		return winPrizes.get(prize);
	}

	public int getWinPrizeSize() {
		return winPrizes.size();
	}

	public int getTotalWinningMoney() {
		return winPrizes.keySet()
			.stream()
			.mapToInt(winnerResult -> (winnerResult.getWinningMoney() * winPrizes.get(winnerResult)))
			.sum();
	}

	public List<Prize> drawResultWinPrizes() {
		List<Prize> resultPrize = new ArrayList<>(winPrizes.keySet());
		resultPrize.sort(new PrizeComparator());
		return resultPrize;
	}

}
