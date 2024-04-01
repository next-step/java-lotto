package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<WinningType, Long> winningCount(WinningLotto winner) {
        return this.lottos.stream()
                .map(winner::findWinningType)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
