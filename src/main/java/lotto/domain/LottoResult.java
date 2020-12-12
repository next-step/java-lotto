package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LottoResult {
	private final Map<Rank, Long> rank;

	public LottoResult(Map<Rank, Long> rank) {
		this.rank = rank;
	}

	public static LottoResult compareTicketAndWinner(LottoTicket lottoTicket, LottoWinnerNumbers lottoWinnerNumbers) {
		return new LottoResult(lottoTicket.stream().collect(groupingBy(lottoNumbers -> matchesRank(lottoNumbers, lottoWinnerNumbers), HashMap::new, Collectors.counting())));
	}

	public static Rank matchesRank(LottoNumbers targetNumbers, LottoWinnerNumbers lottoWinnerNumbers) {
		int count = lottoWinnerNumbers.getMatchCount(targetNumbers);
		return Rank.ofMatchesCount(count);
	}

	public int askCountOfRank(Rank rankType) {
		return Optional.ofNullable(this.rank.get(rankType)).orElse(0L).intValue();
	}

	public int totalAmountMoney() {
		return this.rank.keySet().stream()
			.map(key -> key.getAmountMoney() + this.rank.get(key))
			.reduce(0L, Long::sum).intValue();
	}
}
