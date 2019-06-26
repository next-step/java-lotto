package lotto.util;

import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketBox {

    private static final int TICKET_PRICE = 1000;

    public static List<Lotto> buy(int amount) {
        return IntStream.rangeClosed(1, amount / TICKET_PRICE)
                .boxed()
                .map(e -> new Lotto(LottoGenerator.generate()))
                .collect(Collectors.toList());
    }

}
