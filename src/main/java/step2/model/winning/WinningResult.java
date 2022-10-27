package step2.model.winning;

import java.util.HashMap;

import step2.model.lotto.Lotto;
import step2.model.lotto.Lottos;

public class WinningResult {

	private static final int MIN_MATCH_COUNT = 3;
	private static final int MAX_MATCH_COUNT = 6;

	private final double prize;
	private final Lotto winningLotto;
	private final Lottos purchaseLottos;
	private final HashMap<Integer, Integer> countMap;

	public WinningResult(Lotto winningLotto, Lottos purchaseLottos) {
		this.winningLotto = winningLotto;
		this.purchaseLottos = purchaseLottos;
		this.countMap = matchCountMap();
		this.prize = calculatePrize();
	}

	public HashMap<Integer, Integer> getCountMap() {
		return this.countMap;
	}

	public double getPrize() {
		return this.prize;
	}

	private HashMap<Integer, Integer> matchCountMap() {
		return purchaseLottos.getMatchCountMap(winningLotto);
	}

	private double calculatePrize() {
		double prize = 0;

		for (int matchCount = MIN_MATCH_COUNT; matchCount < MAX_MATCH_COUNT + 1; matchCount++) {
			WinningAmount winningAmount = WinningAmount.findByMatchCount(matchCount);
			prize += winningAmount.getPrize() * countMap.get(winningAmount.getMatchCount());
		}
		return prize;
	}
}
