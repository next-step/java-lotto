package lotto.dto;

import java.util.EnumMap;
import java.util.Map;

import lotto.domain.CalculatePrize;

public class PrizeStack {
	private final Map<CalculatePrize, Integer> prize;

	public PrizeStack() {
		prize = new EnumMap<>(CalculatePrize.class);
		for (CalculatePrize calculatePrize : CalculatePrize.values()) {
			prize.put(calculatePrize, 0);
		}
	}

	public void add(CalculatePrize calculatePrize) {
		prize.put(calculatePrize, prize.get(calculatePrize) + 1);
	}

	public int countingPrize(CalculatePrize calculatePrize) {
		return prize.get(calculatePrize);
	}

	public int size() {
		return prize.size();
	}

}
