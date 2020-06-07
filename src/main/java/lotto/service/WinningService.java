package lotto.service;

import static java.util.stream.Collectors.*;

import java.util.List;

import lotto.collections.LottoResult;
import lotto.collections.LottoTicket;
import lotto.collections.LottoTickets;
import lotto.collections.WinningNumbers;
import lotto.collections.WinningTicket;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.RewardType;
import lotto.util.LottoProfitCalculator;
import lotto.util.NumberStringParser;

public class WinningService {

	public static WinningNumbers createWinningNumbers(final String winningNumber) {
		List<Integer> winningNumberBeforeList = NumberStringParser.NumberStringToIntegerList(winningNumber);
		return new WinningNumbers(winningNumberBeforeList);
	}

	public static double calculateProfit(List<RewardType> lottoStatistics, int lottoTicketSize) {
		Money winningPrice = RewardType.calculateProfit(lottoStatistics);
		int winningPriceValue = winningPrice.getValue();
		return LottoProfitCalculator.getConvertProfit(winningPriceValue, lottoTicketSize);
	}

	public static LottoResult getLottoResult(final LottoTickets lottoTickets, final WinningTicket winningTicket) {
		return lottoTickets.getLottoTickets().stream()
			.map(winningTicket::checkLottoNumbers)
			.collect(collectingAndThen(toList(), LottoResult::new));
	}

	public static int getMatchCount(WinningNumbers winningNumbers, LottoTicket lottoTicket) {
		return winningNumbers.getWinningNumbers().stream()
			.mapToInt(lottoTicket::getMatchCount).sum();
	}

	public static boolean isBonusBall(final LottoTickets lottoTickets, final LottoNumber bonusBall) {
		return lottoTickets.getLottoTickets().stream()
			.anyMatch(ticket -> ticket.doesContainBonusBall(bonusBall));
	}
}
