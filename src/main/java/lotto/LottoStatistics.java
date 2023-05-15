package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private List<Integer> winningNumbers;
    private Map<Winnings, Integer> statistics = new HashMap<>();

    private static final int ZERO = 0;
    private static final int ONE = 1;


    public LottoStatistics(Lottos lottos, List<Integer> winningNumbers, int bonus) {
        this.winningNumbers = winningNumbers;

        for (Lotto lotto : lottos.getLottos()) {
            Winnings winnings = Winnings.fromMatchCount(lotto.checkLotto(winningNumbers, bonus), lotto.hasBonus(bonus));
            statistics.put(winnings, statistics.getOrDefault(winnings, ZERO) + ONE);
        }
    }

    public Integer getWinningsCount(Winnings winnings) {
        return statistics.getOrDefault(winnings, ZERO);
    }

    public BigDecimal rateOfReturn(BigDecimal payment) {
        BigDecimal returns = calculateTotalReturns();

        return returns.divide(payment, 2, RoundingMode.FLOOR);
    }

    private BigDecimal calculateTotalReturns() {
        BigDecimal totalReturns = BigDecimal.ZERO;

        for (Winnings key : statistics.keySet()) {
            Integer count = statistics.get(key);
            totalReturns = totalReturns.add(key.prize.multiply(BigDecimal.valueOf(count)));
        }
        return totalReturns;
    }

    public enum Winnings {
        FIRST(BigDecimal.valueOf(2_000_000_000), 6),
        SECOND(BigDecimal.valueOf(30_000_000), 6),
        THIRD(BigDecimal.valueOf(1_500_000), 5),
        FOURTH(BigDecimal.valueOf(50_000), 4),
        FIFTH(BigDecimal.valueOf(5_000), 3),
        NOTWIN(BigDecimal.ZERO, 0);

        private BigDecimal prize;
        private int matchCount;

        Winnings(BigDecimal prize, int matchCount) {
            this.prize = prize;
            this.matchCount = matchCount;
        }

        public static Winnings fromMatchCount(int matchCount, boolean matchBonus) {
            for (Winnings value : Winnings.values()) {
                if (matchCount == 6 && matchBonus) return SECOND;
                if (value.matchCount == matchCount) return value;
            }
            return NOTWIN;
        }

        public BigDecimal getPrize() {
            return prize;
        }

        public int getMatchCount() {
            return matchCount;
        }

    }
}
