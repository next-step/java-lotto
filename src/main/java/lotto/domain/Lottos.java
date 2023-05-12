package lotto.domain;

import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

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

    public RankResult countMatching(WinningLotto winningLotto) {
        return new RankResult(lottos.stream()
                .map(winningLotto::findRank)
                .collect(Collectors.groupingBy(match -> match, Collectors.counting())));
    }

    public LottosDto toDto() {
        return lottos.stream()
                .map(Lotto::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottosDto::new));
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

    public Lottos addAll(Lottos other) {
        this.lottos.addAll(other.lottos);
        return new Lottos(this.lottos);
    }
}
