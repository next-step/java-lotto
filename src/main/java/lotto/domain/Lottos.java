package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {

    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Map<Match, Long> countMatching(Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.countMatching(winningLotto))
                .collect(Collectors.groupingBy(match -> match, Collectors.counting()));
    }

    public long size() {
        return lottos.size();
    }

    public Money calculateAmount() {
        return Lotto.LOTTO_AMOUNT.multiply(size());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
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
