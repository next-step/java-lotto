package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int TICKET_PRICE = 1000;

    public static LottoTicket buyTicket(int price) {
        int amount = price / TICKET_PRICE;
        return LottoTicket.of(IntStream.range(0, amount)
                .mapToObj(x -> LottoGenerator.generate())
                .collect(Collectors.toList()));
    }
}
