package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<Rank, Integer> lottoResult;

    public LottoResult(Lottos lottos, WinningLotto winningLotto) {
        this.lottoResult = lottos.findLottoResult(winningLotto);
    }

    public Map<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "lottoResult=" + lottoResult +
                '}';
    }
}
