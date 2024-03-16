package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prizes {

    private final Map<Prize, Integer> prizeCount;

    public Prizes(List<Prize> prizes) {
        this(
            prizes.stream()
                .collect(Collectors.groupingBy(prize -> prize, Collectors.summingInt(prize -> 1)))
        );
    }

    public Prizes(Map<Prize, Integer> prizeCount) {
        this.prizeCount = prizeCount;
    }

    public int count(Prize prize) {
        return prizeCount.getOrDefault(prize, 0);
    }

    public double calcReturnRate(int usedMoney) {
        int returnMoney = 0;
        for (Prize prize : prizeCount.keySet()) {
            returnMoney += prize.amount() * prizeCount.get(prize);
        }
        return (double) returnMoney / usedMoney;
    }
}
