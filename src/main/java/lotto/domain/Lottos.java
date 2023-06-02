package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final int purchaseCount;
    private final LottoCreationStrategy lottoCreationStrategy;
    private final ManuallyCreatedLottos manuallyCreatedLottos;

    public Lottos(int purchaseCount, LottoCreationStrategy lottoCreationStrategy, ManuallyCreatedLottos manuallyCreatedLottos) {
        this.purchaseCount = purchaseCount;
        this.lottoCreationStrategy = lottoCreationStrategy;
        this.manuallyCreatedLottos = manuallyCreatedLottos;
    }

    public LottoResult judge(List<Lotto> lottos, WinningLotto winningLotto) { // lottos 인자 전달 필수, 안 그러면 getCreatedLottos()에서 달라짐.
        return new LottoResult(getJudgeRankResult(lottos, winningLotto));
    }

    private List<Rank> getJudgeRankResult(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::calculateRank)
                .collect(Collectors.toList());
    }

    public List<Lotto> getCreatedLottos() {
        return Stream.concat(manuallyCreatedLottos.getManuallyCreatedLottos().stream(),
                             lottoCreationStrategy.createLottos(purchaseCount).stream()).collect(Collectors.toList());
    }
}
