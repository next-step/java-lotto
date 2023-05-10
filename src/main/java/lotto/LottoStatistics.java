package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private List<Integer> winningNumbers;
    private Map<Winnings, Integer> statistics = new HashMap<>();

    public LottoStatistics(Lottos lottos, List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;

        for (Lotto lotto : lottos.getLottos()) {
            Winnings winnings = Winnings.fromMatchCount(lotto.checkLotto(winningNumbers));
            statistics.put(winnings, statistics.getOrDefault(winnings, 0) + 1);
        }
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

    enum Winnings {
        FIRST(BigDecimal.valueOf(2000000000), 6),
        SECOND(BigDecimal.valueOf(1500000), 5),
        THIRD(BigDecimal.valueOf(50000), 4),
        FOURTH(BigDecimal.valueOf(5000), 3),
        NOTWIN(BigDecimal.ZERO, 0);

        private BigDecimal prize;
        private int matchCount;

        Winnings(BigDecimal prize, int matchCount) {
            this.prize = prize;
            this.matchCount = matchCount;
        }

        public static Winnings fromMatchCount(int matchCount) {
            for (Winnings value : Winnings.values()) {
                if (value.matchCount == matchCount) return value;
            }
            return NOTWIN;
        }
    }
}
