package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
	private EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);

	public Result() {
		for (Rank rank : Rank.values()) {
			result.put(rank, 0);
		}
	}

	public Result(EnumMap<Rank, Integer> result) {
		this.result = result;
	}

	public EnumMap<Rank, Integer> aggregateResult(List<Rank> ranks) {
		for (Rank rank : ranks) {
			result.put(rank, result.get(rank) + 1);
		}
		return result;
	}

	public double calcReturnRate(int totalAmount) {
		return calcTotalAmount() / totalAmount;
	}

	private long calcTotalAmount() {
		long sum = 0;
		for (Map.Entry<Rank, Integer> result : result.entrySet()) {
			sum += result.getKey().getAmount() * result.getValue();
		}

		return sum;
	}
}
