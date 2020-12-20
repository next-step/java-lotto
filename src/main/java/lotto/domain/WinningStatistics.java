package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class WinningStatistics {

	private static final String DOUBLE_FORMAT = "%.2f";

	private List<Prize> prizeResult = new ArrayList<>();

	public WinningStatistics(LottoWallet lottoWallet, WinningLottoTicket winningLottoTicket) {
		for (LottoTickets lottoTickets : lottoWallet.getLottoTickets()) {
			lottoTickets.getLottoTickets()
				.forEach(lottoTicket -> prizeResult.add(winningLottoTicket.matchPrize(lottoTicket)));
		}
	}

	public List<Prize> getPrizeResult() {
		return prizeResult;
	}

	public BigDecimal getWinningSummary() {
		int ticketCount = prizeResult.size();
		int revenue = prizeResult.stream().mapToInt(prize -> prize.getReward()).sum();
		Double buyPrice = Double.valueOf(ticketCount * LottoTickets.getLottoTicketPrice());
		return parseWinningSummaryFormat(revenue / buyPrice);
	}

	public static BigDecimal parseWinningSummaryFormat(Double target) {
		return BigDecimal.valueOf(Double.parseDouble(String.format(DOUBLE_FORMAT, target)));
	}
}
