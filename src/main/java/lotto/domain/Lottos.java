package lotto.domain;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult winningResult(WinningLotto winner) {
        return new LottoResult(this.lottos.stream()
                .map(winner::findWinningType)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}
