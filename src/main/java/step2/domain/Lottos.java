package step2.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getValue() {
        return Collections.unmodifiableList(lottos);
    }

    public Integer getLottoCountByTier(LottoTier targetTier, WinningLotto winningLotto) {
        int count = 0;

        for(Lotto lotto : lottos) {
            count = countSameTier(winningLotto.getLottoTier(lotto), targetTier, count);
        }

        return count;
    }

    private int countSameTier(LottoTier resultTier, LottoTier targetTier, int count) {
        if(targetTier.equals(resultTier)) {
            count++;
        }

        return count;
    }

    public int getSize() {
        return lottos.size();
    }
}
