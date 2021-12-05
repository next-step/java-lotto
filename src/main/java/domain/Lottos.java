package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static domain.Lotto.PRICE;

public class Lottos {
    private static final int STARTING_INDEX_LOTTOS = 0;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int investment() {
        return lottos.size() * PRICE;
    }

    public List<Integer> matchedNumbers(Lotto winningLotto) {
        List<Integer> matched = new ArrayList<>();

        lottos.forEach(lotto -> matched.add(lotto.matchingNumberCount(winningLotto)));

        return matched;
    }

    public static Lottos of(int totalNumberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        IntStream.range(STARTING_INDEX_LOTTOS, totalNumberOfLottos)
                .forEach(i -> lottos.add(Lotto.of()));

        return new Lottos(lottos);
    }
}
