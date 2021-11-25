package lotto.domain;

import lotto.dto.StatisticResult;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Statistics {

    private final Credit credit;
    private final List<Rank> ranks;

    public Statistics(Credit credit, List<Lotto> lottoList, WonLotto wonLotto) {
        this.credit = credit;
        this.ranks = createRanksBy(lottoList, wonLotto);
    }

    public StatisticResult getStatisticResult() {
        List<Rank> ranks = Rank.wonRanks;

        Map<Rank, Long> map = ranks.stream()
            .collect(Collectors.toMap(r -> r, r -> Long.valueOf(0), (a, b) -> b));

        Map<Rank, Long> rankAndCount = getRankAndCountMap(this.ranks);
        map.putAll(rankAndCount);

        return new StatisticResult(map, getProfit(rankAndCount));
    }

    private List<Rank> createRanksBy(List<Lotto> lottoList, WonLotto wonLotto) {
        return lottoList.stream()
            .map(lotto -> wonLotto.getLottoRankBy(lotto))
            .sorted(Comparator.comparing(Rank::getMatch)
                .reversed())
            .collect(Collectors.toList());
    }

    private String getProfit(Map<Rank, Long> map) {
        long profit = map.keySet()
            .stream()
            .mapToLong(rank -> map.get(rank) * rank.getMoney())
            .sum();

        if (profit == 0) {
            return "0";
        }

        BigDecimal bProfit = BigDecimal.valueOf(profit);
        BigDecimal bPurchaseAmount = BigDecimal.valueOf(this.credit.getPurchaseAmount());

        return bProfit.divide(bPurchaseAmount, 2, BigDecimal.ROUND_DOWN)
            .toString();
    }

    private Map<Rank, Long> getRankAndCountMap(List<Rank> ranks) {
        if (ranks == null || ranks.isEmpty()) {
            return Collections.EMPTY_MAP;
        }

        return ranks.stream()
            .filter(rank -> rank != Rank.NONE)
            .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }
}
