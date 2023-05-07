package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int numberOfLotto) {
        this.lottos = createLottos(numberOfLotto);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> createLottos(int numberOfLotto) {
        return IntStream.range(1, numberOfLotto).boxed().map(lotto -> create()).collect(Collectors.toList());
    }

    private Lotto create() {
        return LottoFactory.create();
    }

    public List<Integer> matchesLottos(Lotto winningLotto) {
        return lottos.stream().map(lotto -> lotto.matchesNumber(winningLotto)).collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.stream().map(String::valueOf).collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
