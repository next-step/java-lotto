package lotto.model;

import lotto.AutomaticLottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final Integer LOTTO_PRICE = 1000;

    private LottoStore() {

    }
    public static LottoTickets sell(final Integer payment) {
        Integer lottoCount = payment / LOTTO_PRICE;
        List<LottoPurchaseTicket> lottoPurchaseTickets = IntStream.range(0, lottoCount)
                .mapToObj(i -> LottoPurchaseTicket.newInstance(AutomaticLottoGenerator.generate()))
                .collect(Collectors.toList());
        return LottoTickets.create(lottoPurchaseTickets);
    }
}