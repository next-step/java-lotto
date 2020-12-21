package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class LottoTickets {

	private List<LottoTicket> lottoTickets = new ArrayList<>();

	public LottoTickets(List<LottoTicket> tickets) {
		this.lottoTickets = tickets;
	}

	public int getTicketCount() {
		return lottoTickets.size();
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}

	@Override
	public String toString() {
		return "LottoTickets{" +
			"lottoTickets=" + lottoTickets +
			'}';
	}
}
