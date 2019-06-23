package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatistics {
    private final Money seedMoney;
    private final List<Lotto> lottos;

    public LottoStatistics(Money money, List<Lotto> lottos) {
        this.seedMoney = money;
        this.lottos = lottos;
    }

    public Map<LottoRank, List<Lotto>> getMyRanks(final WinningLotto winningLotto) {
        Map<LottoRank, List<Lotto>> rankMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank rank = lotto.matchLotto(winningLotto);
            List<Lotto> lottos = rankMap.getOrDefault(rank, new ArrayList<>());
            lottos.add(lotto);
            rankMap.put(rank, lottos);
        }
        return rankMap;
    }

    public List<LottoRank> checkMyRanks(final WinningLotto winningLotto) {
        return lottos.stream()
                     .map(lotto -> lotto.matchLotto(winningLotto))
                     .collect(Collectors.toList());
    }

    public double getBenefitPercent(final WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = checkMyRanks(winningLotto);
        final long totalBenefit = lottoRanks.stream()
                                            .map(LottoRank::getMoney)
                                            .mapToLong(Money::getMoney)
                                            .sum();
        return (double) totalBenefit / seedMoney.getMoney();
    }
}
