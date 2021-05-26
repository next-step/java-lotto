package lotto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoMatchResult {

	private List<LottoPrize> results;
	private Lottos purchasedLotto;

	public LottoMatchResult(Lottos purchasedLotto, Lotto winningLotto) {
		this.purchasedLotto = purchasedLotto;
		this.results = purchasedLotto.comparePrize(winningLotto);
	}

	public Map<LottoPrize, Long> getResult() {
			return results.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
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
