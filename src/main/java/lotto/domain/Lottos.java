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

    public Map<WinningType, Long> winningCount(Lotto winner, int bonusNumber) {
        return this.lottos.stream()
                .map(lotto -> lotto.findWinningType(winner, bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
