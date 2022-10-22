package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(int lottoCount) {
        return IntStream.range(0, lottoCount)
            .mapToObj(i -> new Lotto())
            .collect(collectingAndThen(toList(), Lottos::new));
    }

    public int getCount() {
        return lottos.size();
    }
}
