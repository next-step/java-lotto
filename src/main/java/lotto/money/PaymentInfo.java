package lotto.money;

import lotto.lotto.LottoTickets;

import java.util.Objects;

public class PaymentInfo {
    private final Money payment;
    private final int numberOfManualLottoTickets;

    private PaymentInfo(Money payment, LottoTickets manualLottoTickets) {
        validate(payment, manualLottoTickets);

        this.payment = payment;
        this.numberOfManualLottoTickets = manualLottoTickets.size();
    }

    private void validate(Money payment, LottoTickets manualLottoTickets) {
        if (Objects.isNull(payment)) {
            throw new IllegalArgumentException("Money can't be null");
        }

        if (Objects.isNull(manualLottoTickets)) {
            throw new IllegalArgumentException("LottoTickets can't be null");
        }
    }

    public static PaymentInfo of(Money payment, LottoTickets manualLottoTickets) {
        return new PaymentInfo(payment, manualLottoTickets);
    }
}
