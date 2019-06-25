package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistics {
    private final Money seedMoney;
    private final Lottos lottos;

    public LottoStatistics(Money money, Lottos lottos) {
        this.seedMoney = money;
        this.lottos = lottos;
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
