package step2.domain;

import java.util.HashMap;
import java.util.Map;

import static step2.domain.LotteryAgent.PRICE_LOTTERY;

public class LotteryResult {

    private final Map<Rank, Integer> result = new HashMap<>();

    public void add(Rank rank) {
        result.compute(rank, this::addOrDefault);
    }

    private Integer addOrDefault(Rank rank, Integer value) {
        if (value == null) {
            return 1;
        }
        return value + 1;
    }

    public int getMatchResult(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public float getRateOfReturn() {
        Money totalAmount = getTotalAmount();

        Money returnAmount = getReturnAmount();

        return (float) returnAmount.toInt() / totalAmount.toInt();
    }

    private Money getReturnAmount() {
        return result.entrySet() //
                .stream() //
                .map(entry -> { //
                    Rank rank = entry.getKey();
                    Integer count = entry.getValue();
                    return rank.getPrizeAmount().multiply(count);
                }).reduce(Money::add) //
                .orElse(Money.of(0));
    }

    private Money getTotalAmount() {
        return result.values() //
                .stream() //
                .map(PRICE_LOTTERY::multiply) //
                .reduce(Money::add) //
                .orElse(Money.of(0));
    }
}
