package lotto.step2.domain.factory;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentPrice;
import lotto.step2.domain.issuelottostrategy.LottoIssueStrategy;

public class LottoTicketsFactory {
    public static LottoTickets from(LottoIssueStrategy lottoIssueStrategy, PaymentPrice paymentPrice) {
        return lottoIssueStrategy.issueLottoTickets(paymentPrice);
    }
}
