package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResults {
	private final List<LottoResult> results;

	public LottoResults(List<LottoResult> results) {
		this.results = results;
	}

	public static LottoResults compareTicketAndWinner(LottoTicket lottoTicket, LottoWinnerNumbers winningNumber) {
		return new LottoResults(lottoTicket.stream()
			.map(lottoNumbers -> LottoResult.compareNumbers(lottoNumbers, winningNumber))
			.collect(Collectors.toList()));
	}

	public int askCountOfRank(Rank rankType) {
		return Math.toIntExact(this.results.stream()
			.filter(result -> result.isMatchesRank(rankType))
			.count());
	}

	public Stream<LottoResult> getLottoResults() {
		return this.results.stream();
	}
}
