package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seller {
    public static List<Lotto> sell(int money) {
        return IntStream.range(0, money / Lotto.PRICE)
                        .mapToObj(i -> new Lotto())
                        .collect(Collectors.toList());
    }
}
