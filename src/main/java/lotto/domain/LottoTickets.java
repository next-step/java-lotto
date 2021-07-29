package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

	private List<LottoTicket> lottoTickets;

	private LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public static LottoTickets from(List<LottoTicket> lottoTickets) {
		return new LottoTickets(Collections.unmodifiableList(lottoTickets));
	}

	public LottoPrizes getLottoPrizes(LottoTicket winningLottoTicket) {
		List<LottoPrize> lottoPrizes = lottoTickets.stream()
										.map(lottoTicket -> lottoTicket.compareTo(winningLottoTicket))
										.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		return LottoPrizes.from(lottoPrizes);
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}
}
