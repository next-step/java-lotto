package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final int purchaseCount;
    private final LottoCreationStrategy lottoCreationStrategy;

    public Lottos(int purchaseCount, LottoCreationStrategy lottoCreationStrategy) {
        this.purchaseCount = purchaseCount;
        this.lottoCreationStrategy = lottoCreationStrategy;
    }

    public LottoResult judge(List<Lotto> lottos, List<Integer> winningNumbers) {
        return new LottoResult(getJudgeRankResult(lottos, winningNumbers));
    }

    private List<Rank> getJudgeRankResult(List<Lotto> lottos, List<Integer> winningNumbers) {
        return lottos.stream()
                .map(lotto -> Rank.findRank(lotto.getMatchNumbers(winningNumbers)))
                .collect(Collectors.toList());
    }

    public List<Lotto> getCreatedLottos() {
        return lottoCreationStrategy.createLottos(purchaseCount);
    }
}
