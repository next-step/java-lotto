package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount) {
        this(generate(purchaseAmount / Lotto.lottoPrice()));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<Rank> winningResults(WinningNumber winningNumber) {
        return lottos.stream()
                .map(lotto -> lotto.winningResult(winningNumber))
                .collect(Collectors.toList());
    }

    private static List<Lotto> generate(int countOfLotto) {
        return IntStream.rangeClosed(1, countOfLotto)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }

    public Stream<Lotto> stream() {
        return this.lottos.stream();
    }
}
