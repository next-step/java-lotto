package lotto;

import java.util.*;

public class LottoStatistics {

	private final Map<LOTTO_RESULT, Long> countResult;

	public static LottoStatistics create(List<LOTTO_RESULT> lottoResultList) {
		if (lottoResultList.size() == 0) {
			throw new IllegalArgumentException("lottoResultList is empty!");
		}

		Map<LOTTO_RESULT, Long> countResult = new HashMap<>();
		for (LOTTO_RESULT key : LOTTO_RESULT.values()) {
			long count = countEquals(lottoResultList, key);
			countResult.put(key, count);
		}

		return new LottoStatistics(countResult);
	}

	private static <T> long countEquals(List<T> list, T equalsTarget) {
		return list.stream()
				.filter(element -> Objects.equals(element, equalsTarget))
				.count();
	}

	private LottoStatistics(Map<LOTTO_RESULT, Long> countResult) {
		if (countResult.size() != LOTTO_RESULT.values().length) {
			throw new IllegalArgumentException("uncounted LOTTO_RESULT is exist!");
		}

		this.countResult = Collections.unmodifiableMap(countResult);
	}

	public long getCount(LOTTO_RESULT lottoResult) {
		return countResult.get(lottoResult);
	}

	public double calculateIncomeRate() {
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
