package lotto.domain;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class WinningStatistics {

	private LottoTickets userLottoTickets;
	private LottoTicket winnerLottoTicket;
	private Map<Prize, Integer> prizeResult = new HashMap<>();
	private int revenue = 0;

	public WinningStatistics(LottoTickets userLottoTickets, LottoTicket winnerLottoTicket) {
		this.userLottoTickets = userLottoTickets;
		this.winnerLottoTicket = winnerLottoTicket;
		awards();
	}

	private void awards() {
		for (LottoTicket lottoTicket : userLottoTickets.getLottoTickets()) {
			Prize resultKey = Prize.of(winnerLottoTicket.getMatchCount(lottoTicket));
			prizeResult.put(resultKey, prizeResult.getOrDefault(resultKey, 0) + 1);
			revenue += resultKey.getReward();
		}
		fillEmptyResult();
		prizeSort();
	}

	private void fillEmptyResult() {
		for(Prize prize : Prize.values()){
			putEmptyResult(prize);
		}
	}

	private void prizeSort() {
		prizeResult = prizeResult.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByKey(Comparator.comparing(Prize::getMatchCount)))
			.collect(Collectors.toMap(
				Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}

	private void putEmptyResult(Prize prize) {
		if(!prizeResult.containsKey(prize)){
			prizeResult.put(prize, 0);
		}
	}

	public Map<Prize, Integer> getPrizeResult() {
		return prizeResult;
	}

	public BigDecimal getWinningSummary() {
		Double buyPrice = Double.valueOf(userLottoTickets.getTicketCount() * LottoTickets.getLottoTicketPrice());
		return BigDecimal.valueOf(Double.parseDouble(String.format("%.2f",revenue / buyPrice)));
	}
}
