package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		for(LottoTicket lottoTicket : userLottoTickets.getLottoTickets()){
			Prize resultKey = Prize.of(winnerLottoTicket.getMatchCount(lottoTicket));
			prizeResult.put(resultKey,prizeResult.getOrDefault(resultKey , 0) + 1);
			revenue += resultKey.getReward();
		}
	}

	public Map<Prize, Integer> getPrizeResult() {
		return prizeResult;
	}

	public int getWinningAverage(){
		return revenue / (userLottoTickets.getTicketCount() * LottoTickets.getLottoTicketPrice());
	}
}
