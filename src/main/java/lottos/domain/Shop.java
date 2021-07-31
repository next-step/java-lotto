package lottos.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {

    private static final int PRICE_PER_PIECE = 1000;

    public Lottos issue(int price) {
        List<Lotto> lottos = this.calculate(price);
        return new Lottos(lottos);
    }

    private List<Lotto> calculate(int price) {
        int count = price / PRICE_PER_PIECE;
        return IntStream.range(0, count)
                .mapToObj(r -> new Lotto())
                .collect(Collectors.toList());
    }
}
