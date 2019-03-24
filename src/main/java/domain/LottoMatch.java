package domain;

import util.Calculator;
import util.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMatch {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private List<Integer> exceptBonusBallWinningNumbers;

    public LottoMatch(List<Lotto> lottos, List<Integer> winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.exceptBonusBallWinningNumbers = this.winningNumbers.stream().limit(Constant.MAX_LOTTO_NUMBER_COUNT).collect(Collectors.toList());
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

    private Map<String, Object> calculateMatchResult(Lotto lotto) {
        Map<String, Object> matchResult = new HashMap<>();
        int matchCount = this.matchCount(lotto);
        matchResult.putIfAbsent("matchCount", matchCount);
        matchResult.putIfAbsent("isContainsBonusBall", this.isContainsBonusBall(matchCount, lotto));
        return matchResult;
    }

    private int matchCount(Lotto lotto) {
        int matchCount = 0;
        for (Integer winningNumber : this.exceptBonusBallWinningNumbers) {
            if (lotto.isContains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isContainsBonusBall(int matchCount, Lotto lotto) {
        boolean isContainsBonusBall = false;
        if (matchCount == LottoRank.SECOND.getMatchCount()) {
            int bonusBall = this.winningNumbers.stream().reduce((fitst, second) -> second).orElse(null);
            isContainsBonusBall = lotto.isContains(bonusBall);
        }

        return isContainsBonusBall;
    }
}
