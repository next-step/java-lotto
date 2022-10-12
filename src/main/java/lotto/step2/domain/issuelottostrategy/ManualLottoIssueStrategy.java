package lotto.step2.domain.issuelottostrategy;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentPrice;
import lotto.step2.view.input.InputView;

public class ManualLottoIssueStrategy implements LottoIssueStrategy {
    @Override
    public LottoTickets issueLottoTickets(final PaymentPrice paymentPrice) {
        return InputView.inputManualLottoTickets(paymentPrice);
    }
}
