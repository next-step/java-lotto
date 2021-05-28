package kht2199.lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import kht2199.Rank;

public class LottoPrizeResult {

	/**
	 * 일치갯수, 일치갯수에 대한 상금의 총합을 기록한다.
	 */
	private Map<Rank, Integer> matchedPrizeMap;

	public LottoPrizeResult() {
		reset();
	}

	public void addWinningMoney(Rank rank) {
		Integer totalPrize = matchedPrizeMap.get(rank);
		matchedPrizeMap.put(rank, totalPrize + rank.getWinningMoney());
	}

	public int totalPrize() {
		int sum = 0;
		for (Integer value : matchedPrizeMap.values()) {
			sum += value;
		}
		return sum;
	}

	public void reset() {
		this.matchedPrizeMap = new HashMap<>();
		for (Rank value : Rank.values()) {
			matchedPrizeMap.put(value, 0);
		}
	}

	public Map<Rank, Integer> getMatchedPrizeMap() {
		return Collections.unmodifiableMap(matchedPrizeMap);
	}
}
