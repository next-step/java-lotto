package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class MatchResult {

    private final Map<Match, Integer> result;

    public MatchResult(Map<Match, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static MatchResult check(Lottos lottos, Lotto winningLotto) {
        Map<Match, Integer> result = initResult();
        for (Lotto lotto : lottos.getLottos()) {
            Match match = Match.valueOf(winningLotto.match(lotto));
            result.put(match, result.get(match) + 1);
        }
        return new MatchResult(result);
    }

    private static Map<Match, Integer> initResult() {
        Map<Match, Integer> init = new HashMap<>();
        for (Match value : Match.values()) {
            init.put(value, 0);
        }
        return init;
    }

    public int getMatchCount(Match match) {
        return result.get(match);
    }

    public BigDecimal rateOfReturn(int inputMoney) {
        BigDecimal money = new BigDecimal(inputMoney);
        BigDecimal totalPrize = new BigDecimal(calcTotalPrize());
        return totalPrize.divide(money, 2, RoundingMode.HALF_UP);
    }

    private int calcTotalPrize() {
        int totalPrize = 0;
        List<Match> matches = Match.winningValues();
        for (Match match : matches) {
            totalPrize += match.getPrizeMoney() * getMatchCount(match);
        }

        return totalPrize;
    }

    public Map<Match, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

}
