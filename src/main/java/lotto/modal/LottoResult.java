package lotto.modal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

	private static final String PRINT_LOTTO_RANK_COUNT_MSG = "개\n";
	private final List<LottoRank> ranks;

	public LottoResult(List<LottoRank> ranks) {
		this.ranks = ranks;
	}

	public List<String> rankCount() {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> !lottoRank.equals(LottoRank.NOTHING_RANK))
			.map(lottoRank -> lottoRank.getRankMessage() + getRankCount(lottoRank) + PRINT_LOTTO_RANK_COUNT_MSG)
			.collect(Collectors.toList());
	}

	private long getRankCount(LottoRank target) {
		return ranks.stream()
			.filter(lottoRank -> lottoRank.equals(target))
			.count();
	}

	public BigDecimal report(Money money) {
		return money.getYield(totalPrize());
	}

	private long totalPrize() {
		return ranks.stream()
			.mapToLong(LottoRank::getWinnerPrize)
			.sum();
	}
}
