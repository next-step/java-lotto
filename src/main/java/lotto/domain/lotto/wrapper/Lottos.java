package lotto.domain.lotto.wrapper;

import lotto.domain.lotto.LotteryRank;
import lotto.domain.rankcount.RankCount;
import lotto.domain.rankcount.RankCountGroup;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.domain.lotto.LotteryRank.*;

public class Lottos {

    private final List<LottoNumbers> lottos;

    public Lottos(List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }

    public int getNumOfLotto() {
        return this.lottos.size();
    }

    public RankCountGroup groupByRank(WinningNumber winningNumber) {
        LotteryRank[] ranks = values();

        return new RankCountGroup(Arrays.stream(ranks)
            .map(rank -> new RankCount(rank, countByRank(winningNumber, rank)))
            .collect(Collectors.toUnmodifiableList()));
    }

    private long countByRank(WinningNumber winningNumber, LotteryRank rank) {
        List<LottoNumbers> filteredLottos = filterByRank(winningNumber, rank);

        if (SECOND == rank) {
            return count(winningNumber::containsBonus, filteredLottos);
        }

        if (THIRD == rank) {
            return count(winningNumber::containsNotBonus, filteredLottos);
        }

        return count((i) -> true, filteredLottos);
    }

    private List<LottoNumbers> filterByRank(WinningNumber winningNumber, LotteryRank rank) {
        return lottos.stream()
            .filter(lotto -> rank.isEqualCount(winningNumber.countMatchingNumbers(lotto)))
            .collect(Collectors.toUnmodifiableList());
    }

    private long count(Predicate<LottoNumbers> predicate, List<LottoNumbers> count) {
        return count.stream()
            .filter(predicate)
            .count();
    }
}
