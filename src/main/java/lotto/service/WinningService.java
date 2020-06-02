package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.collections.LottoResult;
import lotto.collections.LottoTickets;
import lotto.collections.Money;
import lotto.collections.RewardType;
import lotto.collections.WinningNumbers;
import lotto.domain.LottoNumber;

public class WinningService {

	public WinningNumbers createWinningNumbers(final String winningNumber) {
		List<Integer> winningNumberBeforeList = Arrays.stream(winningNumber.split(","))
			.map(String::trim)
			.map(Integer::valueOf)
			.collect(Collectors.toList());
		return new WinningNumbers(winningNumberBeforeList);
	}

	public LottoResult calculateLottoMatches(final LottoTickets lottoTickets,
		final WinningNumbers winningNumbers) {
		return lottoTickets.calculateLottoResult(winningNumbers);
	}

	public Money calculateProfit(List<RewardType> lottoStatistics) {
		int value = Arrays.stream(RewardType.values())
			.filter(lottoStatistics::contains)
			.map(type -> type.getReward().getValue() *
				lottoStatistics.stream()
					.filter(element -> element.equals(type))
					.mapToInt(i -> 1)
					.sum()
			).reduce(0, Integer::sum);
		return new Money(value);
	}

	public boolean isBonusBall(final LottoTickets lottoTickets, final LottoNumber bonusBall) {
		return lottoTickets.getLottoTickets().stream()
			.anyMatch(ticket -> ticket.doesContainBonusBall(bonusBall));
	}
}
