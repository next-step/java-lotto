package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    public static final int LOTTO_PRICE = 1000;

    private LottoStore() {

    }

    public static List<Lotto> issue(int amount) {
        int requestTicketCount = amount / LOTTO_PRICE;
        return IntStream.range(0, requestTicketCount)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }
}
