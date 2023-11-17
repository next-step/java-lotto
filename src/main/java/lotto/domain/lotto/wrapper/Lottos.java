package lotto.domain.lotto.wrapper;

import lotto.domain.lotto.LotteryRank;
import lotto.domain.rankcount.RankCount;
import lotto.domain.rankcount.RankCountGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.domain.lotto.LotteryRank.*;

public class Lottos {

    private List<LottoNumbers> lottos = new ArrayList<>();

    public Lottos(List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }

    @SafeVarargs
    public Lottos(Set<Integer>... lottos) {
        Arrays.stream(lottos)
            .forEach(lotto -> this.lottos.add(new LottoNumbers(lotto)));
    }

    public int getNumOfLotto() {
        return this.lottos.size();
    }

    public RankCountGroup groupByRankCount(WinningNumber winningNumber) {
        LotteryRank[] ranks = values();

        return new RankCountGroup(Arrays.stream(ranks)
            .map(rank -> new RankCount(rank, countByRank(winningNumber, rank)))
            .collect(Collectors.toUnmodifiableList()));
    }

    private long countByRank(WinningNumber winningNumber, LotteryRank rank) {
        List<LottoNumbers> filteredLottos = filterByRank(winningNumber, rank);

        if (BONUS == rank) {
            return count(winningNumber::isBonus, filteredLottos);
        }

        if (SECOND == rank) {
            return count(winningNumber::isSecond, filteredLottos);
        }

        return count((i) -> true, filteredLottos);
    }

    private List<LottoNumbers> filterByRank(WinningNumber winningNumber, LotteryRank rank) {
        return lottos.stream()
            .filter(lotto -> rank.equalsMatchingCount(lotto.countMatchingNumbers(winningNumber)))
            .collect(Collectors.toUnmodifiableList());
    }

    private long count(Predicate<LottoNumbers> predicate, List<LottoNumbers> count) {
        return count.stream()
            .filter(predicate)
            .count();
    }
}
