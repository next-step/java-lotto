package lotto.result;

import lotto.LottoStore;

import java.util.*;

public class LottoStatistics {

	private final Map<LottoResult, Long> countResult;

	public LottoStatistics(List<LottoResult> lottoResultList) {
		if (lottoResultList.isEmpty()) {
			throw new IllegalArgumentException("lottoResultList is empty!");
		}

		Map<LottoResult, Long> countResult = new HashMap<>();
		for (LottoResult key : LottoResult.values()) {
			long count = countEquals(lottoResultList, key);
			countResult.put(key, count);
		}

		this.countResult = Collections.unmodifiableMap(countResult);
	}

	private static <T> long countEquals(List<T> list, T equalsTarget) {
		return list.stream()
				.filter(element -> Objects.equals(element, equalsTarget))
				.count();
	}

	public long getCount(LottoResult lottoResult) {
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

	public long calculateAllCount() {
		return countResult.values().stream()
				.mapToLong(value -> value)
				.sum();
	}

	private long calculateIncome() {
		return this.countResult.entrySet().stream()
				.mapToLong(entry -> multiplyAmount(entry.getKey(), entry.getValue()))
				.sum();
	}

	private static long multiplyAmount(LottoResult lottoResult, long count) {
		return lottoResult.getAmount() * count;
	}
}
