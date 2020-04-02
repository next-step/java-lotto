package lotto.model;

import lotto.model.wrapper.Payment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    private LottoStore() {
    }

    public static LottoTickets sell(final Payment payment, final LottoTickets manualLottoTickets) {
        List<LottoTicket> lottoTickets = IntStream.range(0, payment.countLottoTicket())
                .mapToObj(i -> LottoTicket.newInstance())
                .collect(Collectors.toList());
        return new LottoTickets(lottoTickets);
    }
}
