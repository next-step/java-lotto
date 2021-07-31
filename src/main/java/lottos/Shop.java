package lottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {

    private static final int PRICE_PER_PIECE = 1000;

    public Lottos issue(String input) {
        List<Lotto> lottos = this.calculate(input);
        return new Lottos(lottos);
    }

    private List<Lotto> calculate(String input) {
        int price = Integer.parseInt(input);
        int count = price / PRICE_PER_PIECE;
        return IntStream.range(0, count)
                .mapToObj(r -> new Lotto())
                .collect(Collectors.toList());
    }
}
