package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class WinningStatistics {

	private static final String DOUBLE_FORMAT = "%.2f";

	private List<Prize> prizeResult = new ArrayList<>();

	public WinningStatistics(LottoTickets userLottoTickets, LottoTicket winnerLottoTicket) {
		prizeResult = awards(userLottoTickets, winnerLottoTicket);
	}

	private List<Prize> awards(LottoTickets userLottoTickets, LottoTicket winnerLottoTicket) {
		return userLottoTickets.getLottoTickets()
			.stream()
			.map(lottoTicket -> Prize.of(lottoTicket.getMatchCount(winnerLottoTicket)))
			.collect(Collectors.toList());
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
