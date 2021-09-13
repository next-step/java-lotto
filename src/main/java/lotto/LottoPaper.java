package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoPaper implements LottoReport {

	private final List<LottoRank> ranks;
	private final Money lottoPrice;

	public LottoPaper(List<LottoRank> ranks, Money lottoPrice) {
		this.ranks = ranks;
		this.lottoPrice = lottoPrice;
	}

	public LottoPaper() {
		this(Arrays.asList(), new Money(0));
	}

	public LottoPaper write(LottoRank rank, Money price) {
		List<LottoRank> lottoRanks = new ArrayList<>();
		lottoRanks.addAll(this.ranks);
		lottoRanks.add(rank);
		return new LottoPaper(lottoRanks, lottoPrice.add(price));
	}

	@Override
	public int lottoMatchCount(int matchedNumberCount, boolean isMatchBonus) {
		return (int)this.ranks
			.stream()
			.filter(rank -> rank.isWinning(matchedNumberCount, isMatchBonus))
			.count();
	}

	@Override
	public double profit() {
		Money totalProfit = ranks
			.stream()
			.map(LottoRank::reward)
			.reduce(Money::add)
			.get();
		return totalProfit.divide(this.lottoPrice).money();
	}
}
