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
    private int amount;

    public IssueStats(int amount) {
        this.amount = amount;
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
        BigDecimal earningAmount = BigDecimal.ZERO;
        BigDecimal fifthCount = new BigDecimal(Integer.toString(result.get(Rank.FIFTH)));
        BigDecimal fourthCount = new BigDecimal(Integer.toString(result.get(Rank.FOURTH)));
        BigDecimal thirdCount =  new BigDecimal(Integer.toString(result.get(Rank.THIRD)));
        BigDecimal secondCount =  new BigDecimal(Integer.toString(result.get(Rank.SECOND)));
        BigDecimal firstCount = new BigDecimal(Integer.toString(result.get(Rank.FIRST)));
        BigDecimal fifth = new BigDecimal(오천원);
        BigDecimal fourth = new BigDecimal(오만원);
        BigDecimal third = new BigDecimal(백오십만원);
        BigDecimal second = new BigDecimal(삼천만원);
        BigDecimal first = new BigDecimal(이십억);
        BigDecimal totalSum = earningAmount.add(fifth.multiply(fifthCount)).add(fourth.multiply(fourthCount)).add(third.multiply(thirdCount)).add(second.multiply(secondCount)).add( first.multiply(firstCount));
        return totalSum.doubleValue();
    }

    public double getGrossReturn() {
        return (((getDoubleTotalSum() / amount) - 1) * 100) / 100 + 1;
    }

    public int checkCount(Rank rank) {
        return result.get(rank);
    }
}
