package lotto.domain.lotto.wrapper;

import lotto.domain.lotto.LotteryRank;
import lotto.domain.lotto.Lotto;
import lotto.domain.rankcount.RankCount;
import lotto.domain.rankcount.RankCountGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.lotto.LotteryRank.*;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos() {
    }

    public Lottos(List<LottoNumbers> lottoNumberses) {
        lottoNumberses.forEach(numbers -> lottos.add(new Lotto(numbers)));
    }

    public int getNumOfLotto() {
        return this.lottos.size();
    }

    public RankCountGroup groupByRankCount(LottoNumbers winningNumbers) {
        LotteryRank[] ranks = values();

        List<RankCount> rankCounts = Arrays.stream(ranks)
            .map(rank -> new RankCount(rank, countByRank(winningNumbers, rank)))
            .collect(Collectors.toUnmodifiableList());

        return new RankCountGroup(rankCounts);
    }

    private long countByRank(LottoNumbers winningNumbers, LotteryRank rank) {
        return lottos.stream()
            .map(lotto -> lotto.countMatchingNumbers(winningNumbers))
            .filter(rank::equalsWith)
            .count();
    }
}
