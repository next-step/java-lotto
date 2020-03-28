package lotto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final Integer LOTTO_PRICE = 1000;

    public static LottoTickets sell(final Integer payment) {
        Integer lottoCount = payment / LOTTO_PRICE;
        List<LottoTicket> lottoTickets = IntStream.range(0, lottoCount)
                .mapToObj(i -> LottoTicket.newInstance(RandomLottoGenerator.generate()))
                .collect(Collectors.toList());
        return LottoTickets.create(lottoTickets);
    }
}
