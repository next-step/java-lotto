package lotto.domain;

import java.util.HashMap;
import java.util.Map;

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
}
