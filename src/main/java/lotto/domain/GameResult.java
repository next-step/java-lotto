package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {

    private final Map<Award, Long> results;
    private final double yield;

    public GameResult(LottoTickets lottoTickets, ResultLotto resultLotto, int startMoney) {
        results = createResultsToMap(lottoTickets, resultLotto);
        this.yield = calculateYield(sumOfAward(), startMoney);
    }


    public Long getResultByCount(Award award) {
        return results.getOrDefault(award, 0L);
    }

    public double getYield() {
        return yield;
    }

    private long sumOfAward() {
        return results.keySet().stream()
            .mapToLong(this::sumWinningPriceByAward)
            .sum();
    }

    private long sumWinningPriceByAward(Award award) {
        return results.get(award) * award.getReward();
    }

    private double calculateYield(long sum, int startMoney) {
        if (sum == 0) {
            return 0L;
        }

        return sum / (double) startMoney;
    }

    private Map<Award, Long> createResultsToMap(LottoTickets lottoTickets,
        ResultLotto resultLotto) {
        return lottoTickets.getTickets().stream()
            .map(resultLotto::award)
            .collect(Collectors.groupingBy(award -> award, Collectors.counting()));
    }

}
