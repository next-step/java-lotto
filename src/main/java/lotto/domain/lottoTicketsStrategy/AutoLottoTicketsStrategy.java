package lotto.domain.lottoTicketsStrategy;

import static lotto.domain.LottoTickets.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.BuyInfo;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public class AutoLottoTicketsStrategy implements LottoTicketsStrategy {

	public static final List<Integer> NUMBER_BOUNDARY = IntStream.rangeClosed(LottoNumber.MINIMUM_OF_LOTTO_NUMBER,
		LottoNumber.MAXIMUM_OF_LOTTO_NUMBER)
		.boxed()
		.collect(Collectors.toList());

	@Override
	public LottoTickets play(BuyInfo buyInfo) {
		return new LottoTickets(createTickets(buyInfo));
	}

	private List<LottoTicket> createTickets(BuyInfo buyInfo) {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		int ticketCount = buyInfo.getAutoAutoTicketCount();
		for (int i = 0; i < ticketCount; i++) {
			lottoTickets.add(new LottoTicket(randomLottoNumbers()));
		}
		return lottoTickets;
	}

	private List<LottoNumber> randomLottoNumbers() {
		Collections.shuffle(NUMBER_BOUNDARY);
		return NUMBER_BOUNDARY.stream()
			.map(LottoNumber::new)
			.limit(LottoTicket.LOTTO_TICKET_NUMBER_COUNT)
			.sorted(Comparator.comparing(LottoNumber::getNumber))
			.collect(Collectors.toList());
	}

}
