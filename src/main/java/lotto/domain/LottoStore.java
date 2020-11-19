package lotto.domain;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.LottoTicketsFactory;

import java.util.Objects;

public class LottoStore {
    public static LottoTickets sell(final Money money) {
        if (Objects.isNull(money)) {
            return LottoTickets.EMPTY;
        }

        final Money lottoPrice = LottoTicket.getPrice();
        return createLottos(money, lottoPrice);
    }

    private static LottoTickets createLottos(final Money money, final Money lottoPrice) {
        final int lottoCount = money.divideWithoutRemainder(lottoPrice);
        return LottoTicketsFactory.create(lottoCount);
    }
}
