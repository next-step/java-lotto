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

    public LottoResult judge(List<Lotto> lottos, WinningLotto winningLotto) { // lotts 인자 전달 필수, 안 그러면 getCreatedLottos()에서 달라짐.
        return new LottoResult(getJudgeRankResult(lottos, winningLotto));
    }

    private List<Rank> getJudgeRankResult(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::calculateRank)
                .collect(Collectors.toList());
    }

    public List<Lotto> getCreatedLottos() {
        return lottoCreationStrategy.createLottos(purchaseCount);
    }
}
