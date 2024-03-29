package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IssuedLottos {
    public static final int WINNING_THRESHOLD = 2;
    List<Lotto> lottos;

    public IssuedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<WinningType, Long> winningStatistic(List<Integer> winningNumbers, int bonusNumber) {
        return this.lottos.stream()
                .map(lotto -> lotto.findWinningType(winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
