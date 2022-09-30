package lotto.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lottos {
    private static final Integer UNIT_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(RandomGenerator randomGenerator, Integer amount) {
        int count = amount / UNIT_PRICE;
        this.lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(randomGenerator))
                .collect(toList());
    }

    public void forEach(Consumer<Lotto> action) {
        lottos.forEach(action);
    }

    public Integer count() {
        return lottos.size();
    }
}
