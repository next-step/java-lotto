package lotto;

import java.util.EnumMap;

public class Statistics {
	private final EnumMap<Prize, Integer> statusMap = new EnumMap<>(Prize.class);

	public Statistics() {
		for (Prize prize : Prize.values()) {
			statusMap.put(prize, 0);
		}
	}

	public int status(Prize prize) {
		return statusMap.get(prize);
	}

	public int totalCount() {
		return statusMap.keySet().stream().mapToInt(this::status).sum();
	}

	public void addCount(Prize prize) {
		statusMap.put(prize, status(prize) + 1);
	}
}
