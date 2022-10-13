package lotto.step2.domain.issuelottostrategy;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentInformation;
import lotto.step2.view.input.InputView;

public class ManualLottoIssueStrategy implements LottoIssueStrategy {
    @Override
    public LottoTickets issueLottoTickets(final PaymentInformation paymentInformation) {
        return InputView.inputManualLottoTickets(paymentInformation);
    }
}
