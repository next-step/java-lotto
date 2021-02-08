package lotto.domain;

import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<WinningType, Integer> calculateResult(WinningLotto winningLotto) {
        LottoCalculation.initialMatchResult();

        for (Lotto lotto : this.lottos) {
            int count = LottoCalculation.winningBallMatchNumber(winningLotto, lotto);
            boolean isBonusBall = LottoCalculation.hasBonusBall(lotto.getLottoNumbers(), winningLotto.getBonusBall());

            WinningType winningType = WinningType.match(count, isBonusBall); 

            LottoCalculation.updateCount(winningType);
        }

        return LottoCalculation.getMatchResult();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
