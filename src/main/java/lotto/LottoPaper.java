package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoPaper implements LottoReport {

	private final List<LottoRank> ranks;
	private final int lottoPrice;

	public LottoPaper(List<LottoRank> ranks, int lottoPrice) {
		this.ranks = ranks;
		this.lottoPrice = lottoPrice;
	}

	public LottoPaper() {
		this(Arrays.asList(), 0);
	}

	public LottoPaper write(LottoRank rank, int price) {
		List<LottoRank> lottoRanks = new ArrayList<>();
		lottoRanks.addAll(this.ranks);
		lottoRanks.add(rank);
		return new LottoPaper(lottoRanks, lottoPrice + price);
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
		int totalProfit = ranks
			.stream()
			.map(LottoRank::reward)
			.mapToInt(Integer::intValue)
			.sum();
		return (double)totalProfit / (double)this.lottoPrice;
	}
}
