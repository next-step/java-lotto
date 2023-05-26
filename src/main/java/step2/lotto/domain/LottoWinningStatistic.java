package step2.lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import step2.lotto.utill.DecimalRounder;

public class LottoWinningStatistic {

	private LottoTickets lottoTickets;

	public LottoWinningStatistic(LottoTickets lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public static  LottoWinningStatistic from(LottoTickets lottoTickets) {
		return new LottoWinningStatistic(lottoTickets);
	}

	public LottoWinningStatisticDto calculateStatistic(LottoTicket answerLottoTicket) {
		double profitRate = calculateProfitRate(answerLottoTicket);

		return LottoWinningStatisticDto.of(
			lottoTickets.countMatchedTicket(answerLottoTicket, 3),
			lottoTickets.countMatchedTicket(answerLottoTicket, 4),
			lottoTickets.countMatchedTicket(answerLottoTicket, 5),
			lottoTickets.countMatchedTicket(answerLottoTicket, 6),
			profitRate
		);
	}

	private double calculateProfitRate(LottoTicket answerLottoTicket) {
		int totalPrize = calculateTotalPrize(answerLottoTicket);
		int totalPrice = lottoTickets.getTotalPrice();

		double ratio = (double) totalPrize / totalPrice;

		return DecimalRounder.roundToSecondsDecimal(ratio);
	}

	private int calculateTotalPrize(LottoTicket winningLottoTicket) {
		List<WinningCondition> winningConditions = lottoTickets.match(winningLottoTicket);

		int totalPrize = winningConditions.stream()
			.mapToInt(condition -> condition.getWinningMoney())
			.sum();

		return totalPrize;
	}
}
