package lotto.oop.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueStats {
    private static final String 오천원 = "5000";
    private static final String 오만원 = "50000";
    private static final String 백오십만원 = "1500000";
    private static final String 삼천만원 = "30000000";
    private static final String 이십억 = "2000000000";
    private final Map<Rank, Integer> result;

    public IssueStats() {
        result = new HashMap<>();
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
        result.put(Rank.MISS, 0);
    }

    public void setIssueStats(LottoNumber issuelotto, List<Integer> numbers, int bonus) {
        int key = issuelotto.checkLotto(numbers, bonus);
        Rank rank = Rank.valueOf(key, issuelotto.getBonusCheck());
        result.put(rank, result.get(rank) + 1);
    }

    public double getDoubleTotalSum() {
        BigDecimal total = result.entrySet().stream()
                .map(entry -> BigDecimal.valueOf(entry.getKey().getWinningMoney()).multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        return total.doubleValue();
    }

    public double getGrossReturn() {
        int amount = 0;
        for (int count: result.values()) {
            amount += count;
        }
        amount = amount * 1000;
        return (((getDoubleTotalSum() / amount) - 1) * 100) / 100 + 1;
    }

    public int checkCount(Rank rank) {
        return result.get(rank);
    }
}
