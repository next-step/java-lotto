package lotto.domain.wrapper;

import lotto.domain.LotteryRank;
import lotto.domain.Lotto;
import lotto.domain.RankCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LotteryRank.*;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Numbers> numberses) {
        numberses.forEach(numbers -> lottos.add(new Lotto(numbers)));
    }

    public RankCountGroup groupByRank(Numbers winningNumbers) {
        LotteryRank[] ranks = values();

        List<RankCount> rankCounts = Arrays.stream(ranks)
            .map(rank -> new RankCount(rank, countByRank(winningNumbers, rank)))
            .collect(Collectors.toUnmodifiableList());

        return new RankCountGroup(rankCounts);
    }

    private long countByRank(Numbers winningNumbers, LotteryRank rank) {
        return lottos.stream()
            .map(lotto -> lotto.countMatchingNumbers(winningNumbers))
            .filter(i -> i == rank.matchingCount())
            .count();
    }
}
