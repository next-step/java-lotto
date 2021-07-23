package lotto.lotto;

import java.util.Objects;

public class Lotto {
    private static final int MINIMUM_PAYMENT = 0;

    private final int payment;
    private final LottoTickets lottoTickets;

    public Lotto(int payment, LottoTickets lottoTickets) {
        validate(payment, lottoTickets);
        this.payment = payment;
        this.lottoTickets = lottoTickets;
    }

    private void validate(int payment, LottoTickets lottoTickets) {
        if (payment < MINIMUM_PAYMENT) {
            throw new IllegalArgumentException("Payment must larger than " + MINIMUM_PAYMENT);
        }

        if (Objects.isNull(lottoTickets)) {
            throw new IllegalArgumentException("LottoTickets can't be null");
        }
    }

    public static Lotto init(int payment, LottoTickets lottoTickets) {
        return new Lotto(payment, lottoTickets);
    }
}
