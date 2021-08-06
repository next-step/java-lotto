package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lotto.utils.PrizeComparator;

public class WinPrizes {

	private final Map<Prize, Integer> winPrizes;

	public WinPrizes(Map<Prize, Integer> winPrizes) {
		this.winPrizes = Collections.unmodifiableMap(winPrizes);
	}

	public int findWinPrizeGrade(Prize prize) {
		return winPrizes.get(prize);
	}

	public int getWinPrizeSize() {
		return winPrizes.size();
	}

	public int getTotalWinningMoney() {
		return winPrizes.keySet()
			.stream()
			.mapToInt(winPrize -> (winPrize.getWinningMoney() * winPrizes.get(winPrize)))
			.sum();
	}

	public List<Prize> drawResultWinPrizes() {
		List<Prize> prizes = new ArrayList<>(this.winPrizes.keySet());
		prizes.sort(new PrizeComparator());
		return prizes;
	}

	public int getLottoCount() {
		return winPrizes.values().stream().mapToInt(lottoCount -> lottoCount).sum();
	}
}
