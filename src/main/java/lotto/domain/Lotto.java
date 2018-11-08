package lotto.domain;

import lotto.domain.validator.LottoPurchaseAmountValidator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hspark on 06/11/2018.
 */
public class Lotto {
	private LottoMachine lottoMachine;
	private List<LottoTicket> lottoTicketList;

	public Lotto(LottoMachine lottoMachine) {
		this.lottoMachine = lottoMachine;
	}

	public List<LottoTicket> purchaseLottoTickets(int lottoPurchaseAmount) {
		LottoPurchaseAmountValidator.valid(lottoPurchaseAmount);

		final int lottoTicketCount = lottoPurchaseAmount / LottoConstants.LOTTO_TICKET_AMOUNT;

		List<LottoTicket> lottoTicketList = Stream.generate(() -> LottoTicket.newInstanceByAutomation(lottoMachine))
			.limit(lottoTicketCount).collect(Collectors.toList());

		setLottoTicketList(lottoTicketList);

		return getLottoTicketList();
	}

	public LottoMatchingResult matchNumber(WinningLottoTicket previousWinningTicket) {
		Map<LottoWinnerType, Long> lottoWinnerTypeCountMap = lottoTicketList.stream().
			collect(Collectors.groupingBy(lottoTicket -> previousWinningTicket.matchNumber(lottoTicket),
				Collectors.counting()));

		return new LottoMatchingResult(lottoWinnerTypeCountMap);
	}

	public List<LottoTicket> getLottoTicketList() {
		return Collections.unmodifiableList(lottoTicketList);
	}

	private void setLottoTicketList(List<LottoTicket> lottoTicketList) {
		this.lottoTicketList = lottoTicketList;
	}

}
