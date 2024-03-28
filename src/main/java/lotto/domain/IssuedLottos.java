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

    public Map<WinningType, Long> winningStatistic(List<Integer> winningNumbers) {
        return this.lottos.stream()
                .map(lotto -> lotto.countHits(winningNumbers))
                .filter(count -> count > WINNING_THRESHOLD)
                .map(count -> WinningType.findByHitCount(count))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
