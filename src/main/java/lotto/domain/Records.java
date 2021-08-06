package lotto.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.enums.Rank;

public class Records {

	private final Map<Rank, Integer> records;

	public Records() {
		this.records = new HashMap<>();
		this.records.put(Rank.FOURTH, 0);
		this.records.put(Rank.THIRD, 0);
		this.records.put(Rank.SECOND, 0);
		this.records.put(Rank.FIRST, 0);
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
