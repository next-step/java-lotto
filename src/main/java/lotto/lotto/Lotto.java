package lotto.lotto;

import lotto.money.Money;

import java.util.Objects;

public class Lotto {

    private final Money payment;
    private final LottoTickets lottoTickets;

    public Lotto(Money payment, LottoTickets lottoTickets) {
        validate(payment, lottoTickets);

        this.payment = payment;
        this.lottoTickets = lottoTickets;
    }

    private void validate(Money payment, LottoTickets lottoTickets) {
        if (Objects.isNull(payment)) {
            throw new IllegalArgumentException("Money can't be null");
        }

        if (Objects.isNull(lottoTickets)) {
            throw new IllegalArgumentException("LottoTickets can't be null");
        }
    }

    public static Lotto init(int payment, LottoTickets lottoTickets) {
        return new Lotto(Money.init(payment), lottoTickets);
    }

    public static Lotto init(Money payment, LottoTickets lottoTickets) {
        return new Lotto(payment, lottoTickets);
    }
}
