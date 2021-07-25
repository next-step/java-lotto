package lotto.lotto;

import lotto.money.Money;
import lotto.money.PaymentInfo;
import lotto.number.LottoNumberGenerator;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoMachine {
    public static final Money PRICE_OF_A_TICKET = Money.from(1_000);

    private LottoMachine() {}

    public static Lotto buy(PaymentInfo paymentInfo, LottoTickets lottoTickets) {
        validate(paymentInfo, lottoTickets);

        LottoTickets autoLottoTickets = buyAutoTicket(paymentInfo);
        lottoTickets.merge(autoLottoTickets);

        return Lotto.of(paymentInfo, lottoTickets);
    }

    private static void validate(PaymentInfo paymentInfo, LottoTickets lottoTickets) {
        if (Objects.isNull(paymentInfo)) {
            throw new IllegalArgumentException("PaymentInfo can't be null");
        }

        if (Objects.isNull(lottoTickets)) {
            throw new IllegalArgumentException("LottoTickets can't be null");
        }
    }

    private static LottoTickets buyAutoTicket(PaymentInfo paymentInfo) {
        return Stream.generate(LottoMachine::generateAutoTicket)
                .limit(paymentInfo.getAffordableCount(PRICE_OF_A_TICKET))
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::from));
    }

    private static LottoTicket generateAutoTicket() {
        return LottoTicket.from(LottoNumberGenerator.generate());
    }
}
