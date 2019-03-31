package domain;

import util.Calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> lottoResult = new HashMap<>();

    public LottoResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
        lottos.forEach(lotto -> {
            LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
            this.produceResult(lottoMatchCount);
        });
    }

    private void produceResult(LottoRank lottoMatchCount) {
        this.lottoResult.put(lottoMatchCount, Calculator.nullToZero(lottoResult.get(lottoMatchCount)) + 1);
    }

    public int lottoMatchCount(LottoRank lottoRank) {
        return lottoResult.get(lottoRank) == null ? 0 : lottoResult.get(lottoRank);
    }

}
