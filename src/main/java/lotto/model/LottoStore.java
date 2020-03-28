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
        List<LottoTicket> lottoTickets = IntStream.range(0, lottoCount)
                .mapToObj(i -> LottoTicket.newInstance(AutomaticLottoGenerator.generate()))
                .collect(Collectors.toList());
        return LottoTickets.create(lottoTickets);
    }
}