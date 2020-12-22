package lotto.result;

import lotto.option.LottoMoney;

import java.util.*;

public class LottoStatistics {

	private static final String VALIDATE_FAIL_EMPTY = "lottoResultList is empty!";
	private final Map<LottoResult, Long> countResult;
	private final LottoMoney buyMoney;

	public LottoStatistics(List<LottoResult> lottoResultList, LottoMoney buyMoney) {
		this.countResult = toCountResult(lottoResultList);
		this.buyMoney = buyMoney;
	}

	private Map<LottoResult, Long> toCountResult(List<LottoResult> lottoResultList) {
		if (lottoResultList.isEmpty()) {
			throw new IllegalArgumentException(VALIDATE_FAIL_EMPTY);
		}

		Map<LottoResult, Long> countResult = new HashMap<>();
		for (LottoResult key : LottoResult.values()) {
			long count = countEquals(lottoResultList, key);
			countResult.put(key, count);
		}

		return Collections.unmodifiableMap(countResult);
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
		long income = calculateIncome();
		return this.buyMoney.divideByThis(income);
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
