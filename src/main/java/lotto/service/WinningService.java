package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.collections.LottoResult;
import lotto.collections.LottoTickets;
import lotto.collections.WinningNumbers;
import lotto.domain.LottoNumber;

public class WinningService {

	public static WinningNumbers createWinningNumbers(final String winningNumber) {
		List<Integer> winningNumberBeforeList = Arrays.stream(winningNumber.split(","))
			.map(String::trim)
			.map(Integer::valueOf)
			.collect(Collectors.toList());
		return new WinningNumbers(winningNumberBeforeList);
	}

	public static LottoResult calculateLottoMatches(final LottoTickets lottoTickets,
		final WinningNumbers winningNumbers) {
		return lottoTickets.calculateLottoResult(winningNumbers);
	}

	public static boolean isBonusBall(final LottoTickets lottoTickets, final LottoNumber bonusBall) {
		return lottoTickets.getLottoTickets().stream()
			.anyMatch(ticket -> ticket.doesContainBonusBall(bonusBall));
	}
}
