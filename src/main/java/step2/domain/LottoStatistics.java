package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatistics {
    private final Money seedMoney;
    private final Lottos lottos;

    public LottoStatistics(Money money, Lottos lottos) {
        this.seedMoney = money;
        this.lottos = lottos;
    }

    public Map<LottoRank, Lottos> getMyRanks(final WinningLotto winningLotto) {
        Map<LottoRank, Lottos> rankMap = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            LottoRank rank = lotto.matchLotto(winningLotto);
            Lottos lottos = rankMap.getOrDefault(rank, new Lottos(new ArrayList<>()));
            rankMap.put(rank, lottos.add(lotto));
        }
        return rankMap;
    }

    public List<LottoRank> checkMyRanks(final WinningLotto winningLotto) {
        return lottos.getLottos().stream()
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
