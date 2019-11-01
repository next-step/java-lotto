package lotto.dto;

import lotto.domain.lotto.LottoPrize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoPrizeStat {

	private static final String PRINT_FORMAT = "%s- %s";
	private static final String PRINT_DELIMITER = "\n";

	private final Map<LottoPrize, Long> stat;

	public LottoPrizeStat(Map<LottoPrize, Long> stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		List<String> statPairs = new ArrayList<>();
		for (LottoPrize prize : stat.keySet()) {
			statPairs.add(String.format(PRINT_FORMAT, prize, stat.get(prize)));
		}
		return String.join(PRINT_DELIMITER, statPairs);
	}

}
