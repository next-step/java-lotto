package lotto.model;

import lotto.model.wrapper.Payment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    private LottoStore() {
    }

    public static LottoPurchaseTickets sell(final Payment payment) {
        List<LottoPurchaseTicket> lottoPurchaseTickets = IntStream.range(0, payment.countLottoTicket())
                .mapToObj(i -> LottoPurchaseTicket.newInstance())
                .collect(Collectors.toList());
        return LottoPurchaseTickets.create(lottoPurchaseTickets);
    }
}