package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by hspark on 06/11/2018.
 */
public class Lotto {
	private List<LottoTicket> lottoTicketList;

	public Lotto(List<LottoTicket> lottoTickets) {
		this.lottoTicketList = lottoTickets;
	}

	public LottoMatchingResult matchNumber(WinningLottoTicket previousWinningTicket) {
		Map<LottoWinnerType, Long> lottoWinnerTypeCountMap = lottoTicketList.stream().
			collect(Collectors.groupingBy(lottoTicket -> previousWinningTicket.matchNumber(lottoTicket),
				Collectors.counting()));

		return new LottoMatchingResult(lottoWinnerTypeCountMap);
	}
}
