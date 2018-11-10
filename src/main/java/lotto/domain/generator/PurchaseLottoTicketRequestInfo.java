package lotto.domain.generator;

import lotto.domain.LottoConstants;
import lotto.domain.LottoTicket;
import lotto.domain.common.Money;

import java.util.Collections;
import java.util.List;

/**
 * Created by hspark on 10/11/2018.
 */
public class PurchaseLottoTicketRequestInfo {
	private Money purchaseRequestAmount;
	private List<LottoTicket> manualTickets;

	public PurchaseLottoTicketRequestInfo(Money purchaseRequestAmount, List<LottoTicket> manualTickets) {
		this.purchaseRequestAmount = purchaseRequestAmount;
		this.manualTickets = manualTickets;
	}

	public List<LottoTicket> getManualTickets() {
		return Collections.unmodifiableList(manualTickets);
	}

	public Money getRemainPurchaseAmount() {
		final Money manualLottoTicketAmount = LottoConstants.LOTTO_TICKET_AMOUNT.multiply(manualTickets.size());
		return purchaseRequestAmount.subtract(manualLottoTicketAmount);
	}

}
