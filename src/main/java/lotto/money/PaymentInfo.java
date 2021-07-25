package lotto.money;

import lotto.lotto.LottoTickets;

public class PaymentInfo {
    private final Money payment;
    private final int numberOfManualLottoTickets;

    private PaymentInfo(Money payment, LottoTickets manualLottoTickets) {
        this.payment = payment;
        this.numberOfManualLottoTickets = manualLottoTickets.size();
    }

    public static PaymentInfo of(Money payment, LottoTickets manualLottoTickets) {
        return new PaymentInfo(payment, manualLottoTickets);
    }
}
