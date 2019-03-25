package domain;

import util.Calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatch {
    private List<Lotto> lottos;
    private WinningNumbers winningNumbers;

    public LottoMatch(List<Lotto> lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public Map<LottoRank, Integer> produceResult() {
        Map<LottoRank, Integer> produceResult = new HashMap<>();
        this.lottos.forEach(lotto -> {
            Map<String, Object> matchResult = this.calculateMatchResult(lotto);
            LottoRank lottoMatchCount = LottoRank.findMatchCount((int) matchResult.get("matchCount"), (boolean) matchResult.get("isContainsBonusBall"));
            produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        });
        return produceResult;
    }

    public Map<String, Object> calculateMatchResult(Lotto lotto) {
        Map<String, Object> matchResult = new HashMap<>();
        int matchCount = this.winningNumbers.calcMatchCount(lotto);
        matchResult.putIfAbsent("matchCount", matchCount);
        matchResult.putIfAbsent("isContainsBonusBall", this.winningNumbers.isContainsBonusBall(matchCount, lotto));
        return matchResult;
    }
}
