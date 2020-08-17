package kr.heesu.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public MatchResult matches(WinningNumbers winningNumbers) {
        Map<Long, Long> matches = lottos.stream()
                .map(lotto -> lotto.match(winningNumbers.getWinningNumbers()))
                .collect(Collectors.groupingBy(Function.identity(), counting()));

        return MatchResult.of(matches);
    }

    @Override
    public String toString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
