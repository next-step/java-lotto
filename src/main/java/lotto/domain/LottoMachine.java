package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int TICKET_PRICE = 1000;

    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoTicket buyTicket(int price) {
        int amount = price / TICKET_PRICE;
        return LottoTicket.of(IntStream.range(0, amount)
                .mapToObj(x -> lottoGenerator.generate())
                .collect(Collectors.toList()));
    }
}
