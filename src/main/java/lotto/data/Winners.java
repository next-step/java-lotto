package lotto.data;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Winners {
    private final Map<Rank, Long> result;

    public Winners(Lottos lottos, LottoNumbers winningNumbers, int bonus) {
        this.result = initResult(lottos, winningNumbers, bonus);
    }

    public double calculateYield(long totalSpent) {
        return getTotalEarning() / (double) totalSpent;
    }

    public Map<Rank, Long> getResult() {
        return getResult();
    }

    private long getTotalEarning() {
        int total = 0;

        for (Rank rank : result.keySet()) {
            total += rank.getTotalPrize(result.get(rank));
        }

        return total;
    }

    private Map<Rank, Long> initResult(Lottos lottos, LottoNumbers winningNumbers, int bonus) {
        return getRankList(lottos, winningNumbers, bonus)
                .stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()));
    }

    private List<Rank> getRankList(Lottos lottos, LottoNumbers winningNumbers, int bonus) {
        return lottos.rankLottos(winningNumbers, bonus);
    }
}
