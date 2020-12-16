package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class LottoStatistics {

	private final Map<LOTTO_RESULT, Long> countResult;

	static LottoStatistics create(List<LOTTO_RESULT> lottoResultList) {
		Map<LOTTO_RESULT, Long> counter = lottoResultList.stream().
				collect(Collectors.groupingBy(o -> o, Collectors.counting()));
		return new LottoStatistics(counter);
	}

	private LottoStatistics(Map<LOTTO_RESULT, Long> countResult) {
		if (countResult.size() == 0) {
			throw new IllegalArgumentException("lotto result is empty!");
		}

		this.countResult = Collections.unmodifiableMap(countResult);
	}

	long getCount(LOTTO_RESULT lottoResult) {
		return countResult.getOrDefault(lottoResult, 0L);
	}

	double calculateIncomeRate() {
		long allCount = calculateAllCount();
		if (allCount == 0L) {
			return 0d;
		}

		long income = calculateIncome();
		return (double) income / (allCount * LottoStore.LOTTO_PRICE);
	}

	long calculateAllCount() {
		return countResult.values().stream()
				.mapToLong(value -> value)
				.sum();
	}

	private long calculateIncome() {
		return this.countResult.entrySet().stream()
				.mapToLong(entry -> multiplyAmount(entry.getKey(), entry.getValue()))
				.sum();
	}

	private static long multiplyAmount(LOTTO_RESULT lottoResult, long count) {
		return lottoResult.getAmount() * count;
	}
}
