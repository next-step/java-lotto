package lotto.step2.domain.factory;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentInformation;
import lotto.step2.domain.issuelottostrategy.LottoIssueStrategy;

public class LottoTicketsFactory {
    public static LottoTickets of(LottoIssueStrategy lottoIssueStrategy, PaymentInformation paymentInformation) {
        return lottoIssueStrategy.issueLottoTickets(paymentInformation);
    }
}
