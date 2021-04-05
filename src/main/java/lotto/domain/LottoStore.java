package lotto.domain;

import lotto.factories.LottoTicketFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {
    private static final String PAYMENT_ERROR_MESSAGE = "%d원보다 높은 금액을 입력해야 합니다.";
    private static final int PRICE = 1000;

    public List<LottoTicket> lottoTickets(int payment) {
        if (payment < PRICE) {
            throw new IllegalArgumentException(String.format(PAYMENT_ERROR_MESSAGE, PRICE));
        }

        return Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                .limit(purchasableCount(payment))
                .collect(Collectors.toList());
    }

    public boolean purchasable(int payment, int count) {
        return purchasableCount(payment) >= count;
    }

    public AllLottoTickets allLottoTickets(int payment, List<LottoTicket> manualLottoTickets) {
        return new AllLottoTickets(
                manualLottoTickets,
                Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                        .limit(purchasableCount(payment) - manualLottoTickets.size())
                        .collect(Collectors.toList())
        );
    }

    private int purchasableCount(int payment) {
        return payment / PRICE;
    }
}
