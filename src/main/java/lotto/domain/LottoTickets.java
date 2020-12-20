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

	public static final int LOTTO_TICKET_PRICE = 1000;
	public static final List<Integer> numberBoundary = IntStream.rangeClosed(LottoNumber.MINIMUM_OF_LOTTO_NUMBER,
		LottoNumber.MAXIMUM_OF_LOTTO_NUMBER)
		.boxed()
		.collect(Collectors.toList());

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

	public static int getLottoTicketPrice() {
		return LOTTO_TICKET_PRICE;
	}

	@Override
	public String toString() {
		return "LottoTickets{" +
			"lottoTickets=" + lottoTickets +
			'}';
	}
}
