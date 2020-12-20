package lotto.domain;

import static lotto.domain.LottoTickets.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lotto.view.BuyInfo;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public class AutoLottoTicketsStrategy implements LottoTicketsStrategy {

	@Override
	public LottoTickets generate(BuyInfo buyInfo) {
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
		Collections.shuffle(numberBoundary);
		return numberBoundary.stream()
			.map(LottoNumber::new)
			.limit(LottoTicket.LOTTO_TICKET_NUMBER_COUNT)
			.sorted(Comparator.comparing(LottoNumber::getNumber))
			.collect(Collectors.toList());
	}

}
