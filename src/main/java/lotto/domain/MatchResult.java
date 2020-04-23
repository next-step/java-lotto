package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class MatchResult {

    private final Map<Rank, Integer> result;

    public MatchResult(Map<Rank, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static MatchResult check(Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        Map<Rank, Integer> result = initResult();
        for (Lotto lotto : lottos.getLottos()) {
            boolean isContainsBonus = lotto.contains(bonusNumber);
            Rank rank = Rank.valueOf(winningLotto.match(lotto), isContainsBonus);
            result.put(rank, result.get(rank) + 1);
        }
        return new MatchResult(result);
    }

    private static Map<Rank, Integer> initResult() {
        Map<Rank, Integer> init = new HashMap<>();
        for (Rank value : Rank.values()) {
            init.put(value, 0);
        }
        return init;
    }

    public int getRankCount(Rank rank) {
        return result.get(rank);
    }

    public BigDecimal rateOfReturn(int inputMoney) {
        BigDecimal money = new BigDecimal(inputMoney);
        BigDecimal totalPrize = new BigDecimal(calcTotalPrize());
        return totalPrize.divide(money, 2, RoundingMode.HALF_UP);
    }

    private int calcTotalPrize() {
        int totalPrize = 0;
        List<Rank> ranks = Rank.winningValues();
        for (Rank rank : ranks) {
            totalPrize += rank.getPrizeMoney() * getRankCount(rank);
        }

        return totalPrize;
    }

}
