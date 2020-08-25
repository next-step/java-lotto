package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.Rank;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Lottos {

    private final Set<Lotto> lottos;

    private Lottos(Set<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(Set<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public RankResult matches(WinningNumbers winningNumbers, LottoNumber bonusBall) {
        Map<Rank, Long> matches = lottos.stream()
                .map(lotto -> lotto.match(winningNumbers, bonusBall))
                .collect(Collectors.groupingBy(Function.identity(), counting()));

        return RankResult.of(matches);
    }

    public int size() {
        return this.lottos.size();
    }

    public boolean add(Lotto lotto) {
        return this.lottos.add(lotto);
    }

    public boolean contains(Lotto lotto) {
        return this.lottos.contains(lotto);
    }

    @Override
    public String toString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
