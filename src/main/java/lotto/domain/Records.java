package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import lotto.enums.Rank;

public class Records {

	private final Map<Rank, Integer> records;

	public Records() {
		this.records = new LinkedHashMap<>();
		Arrays.stream(Rank.values())
			.filter(rank -> !rank.equals(Rank.NOTHING))
			.forEach(rank -> records.put(rank, 0));
	}

	public void addRecord(Rank rank) {
		records.computeIfPresent(rank, (key, value) -> ++value);
	}

	public Map<Rank, Integer> getRecords() {
		return records;
	}

	public long sumRevenue() {
		return records.keySet().stream()
							.mapToLong(this::sumRecordRevenue)
							.sum();
	}

	private long sumRecordRevenue(Rank rank) {
		return rank.getReward() * records.get(rank);
	}
}
