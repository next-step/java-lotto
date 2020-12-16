package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class LottoTickets {

	private static final int LOTTO_TICKET_PRICE = 1000;
	private static final List<Integer> numberBoundary = IntStream.rangeClosed(LottoNumber.MINIMUM_OF_LOTTO_NUMBER, LottoNumber.MAXIMUM_OF_LOTTO_NUMBER)
																	.boxed()
																	.collect(Collectors.toList());

	private List<LottoTicket> lottoTickets = new ArrayList<>();

	public LottoTickets(int cash) {
		lottoTickets = createTickets(cash);
	}

	public LottoTickets(List<LottoTicket> customLottoTickets) {
		lottoTickets = customLottoTickets;
	}

	private List<LottoTicket> createTickets(int cash) {
		int ticketCount = cash / LOTTO_TICKET_PRICE;
		for (int i = 0; i < ticketCount; i++) {
			lottoTickets.add(new LottoTicket(randomLottoNumbers()));
		}
		return lottoTickets;
	}

	private List<LottoNumber> randomLottoNumbers() {
		Collections.shuffle(numberBoundary);
		return numberBoundary.stream()
			.map(LottoNumber::new)
			.limit(LottoTicket.LOTTO_TICKET_NUMBER_COUNT)
			.sorted(Comparator.comparing(LottoNumber::getNumber))
			.collect(Collectors.toList());
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
