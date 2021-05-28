package lotto.statistics;

import java.util.HashMap;
import java.util.Map;

import lotto.LottoNumbers;
import lotto.store.Ticket;

public class StatisticsCalculator {

    private static final int WINNING_TYPE_SIZE = 4;
    private static final int LOAD_FACTOR_NEVER_RE_HASHING = 1;
    private static final int EARNING_MATCH_MINIMUM_COUNT = 3;
    private static final int INIT_COUNT = 0;

    private final Ticket ticket;
    private final LottoNumbers winnerLotto;
    private final Map<Ranking, Statistic> statisticByMatchCount;

    public StatisticsCalculator(Ticket ticket, LottoNumbers winnerLotto) {
        this.ticket = ticket;
        this.winnerLotto = winnerLotto;
        this.statisticByMatchCount = new HashMap<>(WINNING_TYPE_SIZE, LOAD_FACTOR_NEVER_RE_HASHING);
        init();
    }

    private void init() {
        for (Ranking ranking : Ranking.values()) {
            statisticByMatchCount.putIfAbsent(ranking, new Statistic(INIT_COUNT, Earn.match(ranking)));
        }
        for (LottoNumbers purchased : ticket.purchasedLotto()) {
            compute(statisticByMatchCount, purchased);
        }
    }

    protected Map<Ranking, Statistic> statisticsMap() {
        return statisticByMatchCount;
    }

    private void compute(Map<Ranking, Statistic> mapByCount, LottoNumbers purchased) {
        int count = winnerLotto.sameCount(purchased);
        if (count < EARNING_MATCH_MINIMUM_COUNT) {
            return;
        }
        Ranking rank = winnerLotto.ranking(purchased);
        mapByCount.computeIfPresent(rank, (k, v) -> v.plusMatchCount());
    }

    public int sumEarningPrice() {
        int result = 0;
        for (Ranking ranking : statisticByMatchCount.keySet()) {
            result += earningPriceByMatchCount(ranking);
        }
        return result;
    }

    private int earningPriceByMatchCount(Ranking ranking) {
        return statisticByMatchCount.get(ranking).earningPrice();
    }

    private String findEarnMessage(Ranking ranking) {
        return statisticByMatchCount.get(ranking).earningMessage();
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder("당첨 통계\n---------\n");
        for (Ranking ranking : Ranking.reverse(winnerLotto.hasBonus())) {
            if (!statisticByMatchCount.containsKey(ranking)) {
                continue;
            }
            message.append(findEarnMessage(ranking));
        }
        message.append(ratioResultMessage());
        return message.toString();
    }

    public double earningRatio() {
        return (double)sumEarningPrice() / (double)ticket.budget();
    }

    private String ratioResultMessage() {
        double ratio = earningRatio();
        return new StringBuilder()
            .append("총 수익률은 ")
            .append(ratio)
            .append("입니다.(기준이 1이기 때문에 결과적으로 ")
            .append(Profit.messageByRatio(ratio))
            .append("라는 의미임)")
            .toString();
    }

}
