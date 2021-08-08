package lottomanual.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

	private static final int MATCHING_STANDARD = 2;
	private static final int DEFAULT_MATCH_COUNT = 0;

	private final Map<LottoProfit, Integer> result = new EnumMap<>(LottoProfit.class);
	private final Lottos lottos;

	public LottoResult(Lottos lottos) {
		this.lottos = lottos;
		for (LottoProfit lottoProfit : LottoProfit.values()) {
			result.put(lottoProfit, DEFAULT_MATCH_COUNT);
		}
	}

	public void match(String winningNumbers, int bonusNumber) {
		match(new Lotto(winningNumbers), LottoNumber.valueOf(bonusNumber));
	}

	public void match(Lotto winningNumbers, LottoNumber bonusNumber) {
		if (winningNumbers.contains(bonusNumber)) {
			throw new LottoBonusNumberException();
		}
		putIntoMap(winningNumbers, bonusNumber);
	}

	private void putIntoMap(Lotto winningNumbers, LottoNumber bonusNumber) {
		for (Lotto lotto : lottos.toList()) {
			int quantity = lotto.matchingQuantityFrom(winningNumbers);
			boolean matchBonus = lotto.contains(bonusNumber);
			putResult(quantity, matchBonus);
		}
	}

	private void putResult(int quantity, boolean matchBonus) {
		if (quantity > MATCHING_STANDARD) {
			LottoProfit lottoProfit = LottoProfit.of(quantity, matchBonus);
			result.put(lottoProfit, getMatchingCount(lottoProfit));
		}
	}

	private int getMatchingCount(LottoProfit quantity) {
		return result.containsKey(quantity) ? result.get(quantity) + 1 : 1;
	}

	public double rate() {
		return rate(profitCount());
	}

	private int profitCount() {
		int totalProfitCount = 0;
		for (Map.Entry<LottoProfit, Integer> entry : result.entrySet()) {
			totalProfitCount += entry.getValue();
		}
		return totalProfitCount;
	}

	private double rate(double totalProfitCount) {
		return totalProfitCount / lottos.size();
	}

	public Map<LottoProfit, Integer> value() {
		return Collections.unmodifiableMap(result);
	}

}
