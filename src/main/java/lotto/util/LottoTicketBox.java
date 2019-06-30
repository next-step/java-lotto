package lotto.util;

import lotto.model.Lotteries;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketBox {

    private static final int TICKET_PRICE = 1000;

    public static Lotteries buy(int amount) {
        return new Lotteries(IntStream.rangeClosed(1, amount / TICKET_PRICE)
                .boxed()
                .map(e -> LottoGenerator.generate())
                .collect(Collectors.toList()));
    }
}
