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

	private static final String DOUBLE_FORMAT = "%.2f";

	private Map<Prize, Integer> prizeResult = new HashMap<>();

	public WinningStatistics(LottoTickets userLottoTickets, LottoTicket winnerLottoTicket) {
		prizeResult = awards(userLottoTickets,winnerLottoTicket);
	}

	private Map<Prize, Integer> awards(LottoTickets userLottoTickets, LottoTicket winnerLottoTicket) {
		for (LottoTicket lottoTicket : userLottoTickets.getLottoTickets()) {
			Prize resultKey = Prize.of(winnerLottoTicket.getMatchCount(lottoTicket));
			prizeResult.put(resultKey, prizeResult.getOrDefault(resultKey, 0) + 1);
		}
		fillEmptyResult();
		prizeSort();
		return prizeResult;
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
		int ticketCount = prizeResult.values().stream().mapToInt(Integer::valueOf).sum();
		int revenue = prizeResult.entrySet().stream().mapToInt(key -> key.getValue() * key.getKey().getReward()).sum();
		Double buyPrice = Double.valueOf(ticketCount * LottoTickets.getLottoTicketPrice());
		return parseWinningSummaryFormat(revenue / buyPrice);
	}

	public static BigDecimal parseWinningSummaryFormat(Double target){
		System.out.println("target : " + target);
		return BigDecimal.valueOf(Double.parseDouble(String.format(DOUBLE_FORMAT,target)));
	}
}
