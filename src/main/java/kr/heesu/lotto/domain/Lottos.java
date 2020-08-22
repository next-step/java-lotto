package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.Rank;

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

    public RankResult matches(WinningNumbers winningNumbers, LottoNumber bonusBall) {
        Map<Rank, Long> matches = lottos.stream()
                .map(lotto -> lotto.match(winningNumbers.getWinningNumbers(), bonusBall))
                .collect(Collectors.groupingBy(Function.identity(), counting()));

        return RankResult.of(matches);
    }

    @Override
    public String toString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
