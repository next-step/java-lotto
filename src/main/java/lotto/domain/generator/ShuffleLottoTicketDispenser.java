package lotto.domain.generator;

import lotto.domain.LottoConstants;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.common.Money;
import lotto.domain.validator.LottoPurchaseAmountValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hspark on 10/11/2018.
 */
public class ShuffleLottoTicketDispenser implements LottoTicketDispenser {
	private LottoMachine lottoMachine;

	public ShuffleLottoTicketDispenser(LottoMachine lottoMachine) {
		this.lottoMachine = lottoMachine;
	}

	public PurchaseLottoTicketResultInfo purchase(PurchaseLottoTicketRequestInfo requestInfo) {
		Money remainAmount = requestInfo.getRemainPurchaseAmount();
		List<LottoTicket> autoTickets = issueLottoTicketByAutomation(remainAmount);

		PurchaseLottoTicketResultInfo purchaseLottoTicketResultInfo = PurchaseLottoTicketResultInfo.builder()
			.autoTickets(autoTickets).manualTickets(requestInfo.getManualTickets()).build();

		return purchaseLottoTicketResultInfo;
	}

	private List<LottoTicket> issueLottoTicketByAutomation(Money lottoPurchaseAmount) {
		LottoPurchaseAmountValidator.valid(lottoPurchaseAmount);
		final int lottoTicketCount = lottoPurchaseAmount.divideValue(LottoConstants.LOTTO_TICKET_AMOUNT).intValue();
		return Stream.generate(() -> LottoTicket.newInstanceByAutomation(lottoMachine))
			.limit(lottoTicketCount).collect(Collectors.toList());
	}
}
