package lotto.step2.domain.issuelottostrategy;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentInformation;

public interface LottoIssueStrategy {
    LottoTickets issueLottoTickets(PaymentInformation paymentInformation);
}
