package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoReport {
	private final int lottoPrice;
	private List<LottoRank> ranks;

	public LottoReport(List<LottoRank> ranks, int lottoPrice) {
		this.ranks = ranks;
		this.lottoPrice = lottoPrice;
	}

	private long countByLottoRank(LottoRank lottorank) {
		return this.ranks
			.stream()
			.filter(rank -> rank.equals(lottorank))
			.count();
	}

	public double profit() {
		int totalProfit = ranks
			.stream()
			.map(rank -> rank.reward())
			.collect(Collectors.summingInt(Integer::intValue));
		int totalPaid = this.ranks.size() * this.lottoPrice;
		return (double)totalProfit / (double)totalPaid;
	}

	public long firstPlace() {
		return countByLottoRank(LottoRank.FIRST);
	}

	public long secondPlace() {
		return countByLottoRank(LottoRank.SECOND);
	}

	public long thirdPlace() {
		return countByLottoRank(LottoRank.THIRD);
	}

	public long fourthPlace() {
		return countByLottoRank(LottoRank.FOURTH);
	}
}
