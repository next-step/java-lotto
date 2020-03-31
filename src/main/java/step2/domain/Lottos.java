package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCountByTier(LottoTier lottoTier, WinningLotto winningLotto) {
        int count = 0;

        for(Lotto lotto : lottos) {
            count = addIfSameTier(lotto.getLottoTier(winningLotto), lottoTier, count);
        }
        return count;
    }

    private int addIfSameTier(LottoTier resultTier, LottoTier lottoTier, int count) {
        if(lottoTier.equals(resultTier)) {
            count++;
        }
        return count;
    }

    public List<Lotto> getValue() {
        return new ArrayList<>(lottos);
    }
}
