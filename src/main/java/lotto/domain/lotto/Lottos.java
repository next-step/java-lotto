package lotto.domain.lotto;

import lotto.domain.rankcount.RankCount;
import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.wrapper.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.lotto.LotteryRank.*;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos() {
    }

    public Lottos(List<Numbers> numberses) {
        numberses.forEach(numbers -> lottos.add(new Lotto(numbers)));
    }

    public int getNumOfLotto() {
        return this.lottos.size();
    }

    public RankCountGroup groupByRankCount(Numbers winningNumbers) {
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
