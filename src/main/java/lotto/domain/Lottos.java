package lotto.domain;

import lotto.dto.LottoDtos;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {

    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public long size() {
        return lottos.size();
    }

    public Map<Rank, Long> countMatching(Lotto winningLotto, LottoNumber bonus) {
        return lottos.stream()
                .map(lotto -> lotto.countMatching(winningLotto, bonus))
                .collect(Collectors.groupingBy(match -> match, Collectors.counting()));
    }

    public LottoDtos toDto() {
        return lottos.stream()
                .map(Lotto::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoDtos::new));
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
