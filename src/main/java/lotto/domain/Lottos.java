package lotto.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount) {
        this(generateAuto(purchaseAmount / Lotto.lottoPrice()));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<Rank> winningResults(WinningNumber winningNumber) {
        return lottos.stream()
                .map(lotto -> lotto.winningResult(winningNumber))
                .collect(Collectors.toList());
    }

    private static List<Lotto> generateAuto(int countOfLotto) {
        return IntStream.rangeClosed(1, countOfLotto)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }

    public Stream<Lotto> stream() {
        return this.lottos.stream();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
