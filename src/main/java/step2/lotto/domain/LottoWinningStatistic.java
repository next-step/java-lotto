package step2.lotto.domain;

import java.util.HashMap;
import java.util.Map;

import step2.lotto.utill.DecimalRounder;

public class LottoWinningStatistic {

	private static final int THREE_MATCH_PRIZE = 5000;

	private static final int FOUR_MATCH_PRIZE = 50000;

	private static final int FIVE_MATCH_PRIZE = 1500000;

	private static final int SIX_MATCH_PRIZE = 2000000000;
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
		int totalPrice = lottoTickets.getSize() * LottoTicket.PRICE;

		double ratio = (double) totalPrize / totalPrice;

		return DecimalRounder.roundToSecondsDecimal(ratio);
	}

	private int calculateTotalPrize(LottoTicket answerLottoTicket) {
		Map<Integer, Integer> countToPrize = new HashMap() {
			{
			put(3,THREE_MATCH_PRIZE);
			put(4,FOUR_MATCH_PRIZE);
			put(5,FIVE_MATCH_PRIZE);
			put(6,SIX_MATCH_PRIZE);
			}
		};

		int totalPrize = countToPrize.entrySet()
			.stream()
			.mapToInt(entry -> lottoTickets.countMatchedTicket(answerLottoTicket, entry.getKey()) * entry.getValue())
			.sum();

		return totalPrize;
	}
}
