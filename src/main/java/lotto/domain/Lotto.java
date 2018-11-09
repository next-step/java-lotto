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
	private PurchaseLottoTickets purchaseLottoTickets;

	public Lotto(LottoMachine lottoMachine) {
		this.lottoMachine = lottoMachine;
	}

	public PurchaseLottoTickets purchaseLottoTickets(int lottoPurchaseAmount, List<LottoTicket> manualTickets) {
		final int remainAmount = getRemainPurchaseAmount(lottoPurchaseAmount, manualTickets);
		List<LottoTicket> autoTickets = issueLottoTicketByAutomation(remainAmount);

		PurchaseLottoTickets purchaseLottoTickets = PurchaseLottoTickets.builder()
			.autoTickets(autoTickets).manualTickets(manualTickets).build();
		setPurchaseLottoTickets(purchaseLottoTickets);

		return purchaseLottoTickets;
	}

	private List<LottoTicket> issueLottoTicketByAutomation(int lottoPurchaseAmount) {
		LottoPurchaseAmountValidator.valid(lottoPurchaseAmount);

		final int lottoTicketCount = lottoPurchaseAmount / LottoConstants.LOTTO_TICKET_AMOUNT;

		return Stream.generate(() -> LottoTicket.newInstanceByAutomation(lottoMachine))
			.limit(lottoTicketCount).collect(Collectors.toList());
	}

	public LottoMatchingResult matchNumber(WinningLottoTicket previousWinningTicket) {
		Map<LottoWinnerType, Long> lottoWinnerTypeCountMap = getLottoTicketList().stream().
			collect(Collectors.groupingBy(lottoTicket -> previousWinningTicket.matchNumber(lottoTicket),
				Collectors.counting()));

		return new LottoMatchingResult(lottoWinnerTypeCountMap);
	}

	public List<LottoTicket> getLottoTicketList() {
		return Collections.unmodifiableList(purchaseLottoTickets.getTickets());
	}

	public void setPurchaseLottoTickets(PurchaseLottoTickets purchaseLottoTickets) {
		this.purchaseLottoTickets = purchaseLottoTickets;
	}

	private int getRemainPurchaseAmount(int lottoPurchaseAmount, List<LottoTicket> manualTickets) {
		final int manualLottoTicketAmount = manualTickets.size() * LottoConstants.LOTTO_TICKET_AMOUNT;
		return lottoPurchaseAmount - manualLottoTicketAmount;
	}
}
