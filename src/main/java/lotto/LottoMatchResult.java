package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMatchResult {

	private List<LottoPrize> results;
	private Lottos purchasedLotto;

	public LottoMatchResult(Lottos purchasedLotto, WinningLotto winningLotto) {
		this.purchasedLotto = purchasedLotto;
		this.results = purchasedLotto.comparePrize(winningLotto);
	}

	public Map<LottoPrize, Long> getResult() {
		Map<LottoPrize, Long> result = Arrays.stream(LottoPrize.values())
			.collect(Collectors.toMap(lottoPrize -> lottoPrize, lottoPrize -> 0L));

		results.forEach(lottoPrize -> {
			result.put(lottoPrize, result.get(lottoPrize) + 1);
		});

		return result;
	}

	public float getProfit() {
		return getTotalWinningAmount() / getPurchaseMoney();
	}

	public int getTotalWinningAmount() {
		return results.stream().mapToInt(LottoPrize::getWinningAmount).sum();
	}

	public int getPurchaseMoney() {
		return purchasedLotto.lottoCount() * LottoMachine.LOTTO_PRICE;
	}
}
