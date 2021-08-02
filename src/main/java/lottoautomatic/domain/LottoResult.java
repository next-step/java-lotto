package lottoautomatic.domain;

import java.util.*;

public class LottoResult {

	private static final int MATCHING_STANDARD = 2;

	private final Map<LottoProfit, Integer> result = new EnumMap<>(LottoProfit.class);
	private final Lottos lottos;

	public LottoResult(Lottos lottos) {
		this.lottos = lottos;
		result.put(LottoProfit.THREE, 0);
		result.put(LottoProfit.FOUR, 0);
		result.put(LottoProfit.FIVE, 0);
		result.put(LottoProfit.SIX, 0);
	}

	public void match(List<Integer> winningNumbers) {
		putIntoMap(winningNumbers);
	}

	private void putIntoMap(List<Integer> winningNumbers) {
		for (Lotto lotto : lottos.toList()) {
			int quantity = lotto.matchingQuantityFrom(winningNumbers);
			putResult(quantity);
		}
	}

	private void putResult(int quantity) {
		if (quantity > MATCHING_STANDARD) {
			LottoProfit lottoProfit = LottoProfit.from(quantity);
			result.put(lottoProfit, getMatchingCount(lottoProfit));
		}
	}

	private int getMatchingCount(LottoProfit quantity) {
		return result.containsKey(quantity) ? result.get(quantity) + 1 : 1;
	}

	public String rate() {
		return rate(profitCount());
	}

	private int profitCount() {
		int totalProfitCount = 0;
		for (Map.Entry<LottoProfit, Integer> entry : result.entrySet()) {
			totalProfitCount += entry.getValue();
		}
		return totalProfitCount;
	}

	private String rate(double totalProfitCount) {
		double rate = totalProfitCount / lottos.size();
		return String.format("%.2f", rate);
	}

	public Map<LottoProfit, Integer> value() {
		return result;
	}

}
