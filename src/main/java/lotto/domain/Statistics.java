package lotto.domain;

import lotto.dto.StatisticsResult;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Statistics {

    private final Credit credit;
    private final List<Lotto> lottos;

    public Statistics(Credit credit, Lotto won, List<Lotto> lottos) {
        this.credit = credit;
        this.lottos = createResult(won, lottos);
    }

    public List<Lotto> createResult(Lotto won, List<Lotto> lottos) {
//        return lottos.stream()
//            .map(l -> l.createWithWon(won))
//            .collect(Collectors.toList());
        return null;
    }

    public StatisticsResult getMatchResult() {
        List<Rank> ranks = Arrays.asList(Rank.FORTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        Map<Rank, Integer> map = new TreeMap<>(Comparator.comparing(Rank::getMatch));
        ranks.forEach(rank -> map.put(rank, 0));

//        lottos.forEach(l -> map.computeIfPresent(l.getRank(), (k, v) -> v + 1));

        int profit = map.keySet().stream().filter(r -> map.get(r) != 0).mapToInt(Rank::getMoney).sum();

        int purchaseAmount = this.credit.getPurchaseAmount();
        return new StatisticsResult(map, String.valueOf(profit != 0 ? (double) profit / purchaseAmount : 0));
    }
}
