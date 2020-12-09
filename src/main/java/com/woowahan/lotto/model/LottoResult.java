package com.woowahan.lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

	private final List<Lotto> lottos;
	private final Map<LottoResultType, Integer> results;

	private LottoResult(WinNumberInput winInput, List<Lotto> lottos) {
		this.lottos = lottos;
		this.results = new HashMap<>();
		Arrays.stream(LottoResultType.values())
			.forEach(resultType -> results.put(resultType, 0));
		compareWinNumber(winInput, lottos);
	}

	public static LottoResult analyze(
		WinNumberInput winInput,
		List<Lotto> lottos
	) {
		return new LottoResult(winInput, lottos);
	}

	private void compareWinNumber(WinNumberInput winInput, List<Lotto> lottos) {
		List<Integer> winNumbers = winInput.getWinNumbers();
		for (Lotto lotto : lottos) {
			List<Integer> lottoNumbers = lotto.getNumbers();
			int matchCount = (int)lottoNumbers.stream()
				.filter(winNumbers::contains)
				.count();
			LottoResultType resultType = LottoResultType.getResultTypeByMatchCount(matchCount);
			increaseCntByResultType(resultType);
		}
	}

	private void increaseCntByResultType(LottoResultType resultType) {
		Integer value = results.get(resultType);
		results.put(resultType, ++value);
	}

	public Map<LottoResultType, Integer> getResults() {
		return results;
	}

	public long getTotalReward() {
		return results.entrySet()
			.stream()
			.mapToLong(entry -> {
				LottoResultType resultType = entry.getKey();
				int matchCount = entry.getValue();
				return resultType.getReward() * matchCount;
			}).sum();
	}

	public double getEarnRate() {
		long totalReward = getTotalReward();
		long purchaseAmount = this.lottos.size() * Lotto.LOTTO_PRICE;
		return (double)totalReward / (double)purchaseAmount;
	}

}
