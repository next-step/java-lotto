package lotto.lotto;

import lotto.number.LottoNumberGenerator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private static final int PRICE_OF_A_TICKET = 1_000;

    private LottoMachine() {}

    public static Lotto buy(int payment) {
        LottoTickets lottoTickets = buyAutoTicket(payment);

        return Lotto.init(payment, lottoTickets);
    }

    private static LottoTickets buyAutoTicket(int payment) {
        return Stream.generate(LottoMachine::generateAutoTicket)
                .limit(payment / PRICE_OF_A_TICKET)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::from));
    }

    private static LottoTicket generateAutoTicket() {
        return LottoTicket.from(LottoNumberGenerator.generate());
    }
}
