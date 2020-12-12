package com.woowahan.lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

	private final List<Lotto> lottos;
	private final Map<LottoResultType, Integer> results;

	private LottoResult(WinNumbers winNumbers, List<Lotto> lottos) {
		this.lottos = lottos;
		this.results = new HashMap<>();
		Arrays.stream(LottoResultType.values())
			.forEach(resultType -> results.put(resultType, 0));
		compareWinNumber(winNumbers);
	}

	public static LottoResult analyze(
		WinNumbers winInput,
		List<Lotto> lottos
	) {
		return new LottoResult(winInput, lottos);
	}

	private void compareWinNumber(WinNumbers winInput) {
		List<LottoNo> winNumbers = winInput.getNumbers();
		LottoNo bonusNumber = winInput.getBonusNumber();
		for (Lotto lotto : this.lottos) {
			List<LottoNo> lottoNumbers = lotto.getNumbers();
			int matchCount = (int)lottoNumbers.stream()
				.filter(winNumbers::contains)
				.count();
			boolean isBonusMatch = matchCount == 5 && compareBonusNumber(lottoNumbers, bonusNumber);
			LottoResultType resultType = LottoResultType.findResultType(matchCount, isBonusMatch);
			increaseCountByResultType(resultType);
		}
	}

	private boolean compareBonusNumber(List<LottoNo> lottoNumbers, LottoNo bonusNumber) {
		return lottoNumbers.stream().anyMatch(bonusNumber::equals);
	}

	private void increaseCountByResultType(LottoResultType resultType) {
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
