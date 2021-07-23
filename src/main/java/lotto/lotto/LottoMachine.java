package lotto.lotto;

import lotto.money.Money;
import lotto.number.LottoNumberGenerator;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    public static final Money PRICE_OF_A_TICKET = Money.init(1_000);

    private LottoMachine() {}

    public static Lotto buy(Money payment) {
        validate(payment);

        LottoTickets lottoTickets = buyAutoTicket(payment);

        return Lotto.init(payment, lottoTickets);
    }

    private static void validate(Money payment) {
        if (Objects.isNull(payment)) {
            throw new IllegalArgumentException("Payment can't be null");
        }
    }

    private static LottoTickets buyAutoTicket(Money payment) {
        return Stream.generate(LottoMachine::generateAutoTicket)
                .limit(payment.getAffordableCount(PRICE_OF_A_TICKET))
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::from));
    }

    private static LottoTicket generateAutoTicket() {
        return LottoTicket.from(LottoNumberGenerator.generate());
    }
}
