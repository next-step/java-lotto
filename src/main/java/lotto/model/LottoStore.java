package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    private LottoStore() {}

    public static PurchasedLottoTickets sell(Payment payment) {
        List<PurchasedLottoTicket> lottoTickets = IntStream.range(0, payment.getCountLottoTicket())
            .mapToObj(i -> PurchasedLottoTicket.create())
            .collect(Collectors.toList());

        return PurchasedLottoTickets.create(lottoTickets);
    }
}
