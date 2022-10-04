package lotto.step2.domain.issuelottostrategy;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentPrice;

public interface LottoIssueStrategy {
    LottoTickets issueLottoTickets(PaymentPrice paymentPrice);
}
