package domain;

import util.Calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatch {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;

    public LottoMatch(List<Lotto> lottos, List<Integer> winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public Map<LottoRank, Integer> produceResult() {
        Map<LottoRank, Integer> produceResult = new HashMap<>();

        this.lottos.forEach(lotto -> {
            int matchCount = this.calculateMatchCount(lotto);
            LottoRank lottoMatchCount = LottoRank.findMatchCount(matchCount);
            produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        });
        return produceResult;
    }

    private int calculateMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (Integer winningNumber : this.winningNumbers) {
            if (lotto.isContains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
