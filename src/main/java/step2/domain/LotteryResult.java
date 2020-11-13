package step2.domain;

import java.util.HashMap;
import java.util.Map;

import static step2.domain.LotteryAgent.PRICE_LOTTERY;

public class LotteryResult {

    private final Map<Rank, Integer> result = new HashMap<>();

    public void add(int matchCount) {
        if (matchCount < 0) {
            throw new OutOfMatchingBoundaryException();
        }

        result.compute(Rank.valueFrom(matchCount), this::addOrDefault);
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
        Money totalAmount = result.values() //
                .stream() //
                .map(PRICE_LOTTERY::multiply) //
                .reduce(Money::add) //
                .orElse(Money.of(0));

        Money returnAmount = result.entrySet() //
                .stream() //
                .map(entry -> { //
                    Rank rank = entry.getKey();
                    Integer count = entry.getValue();
                    return rank.getPrizeAmount().multiply(count);
                }).reduce(Money::add) //
                .orElse(Money.of(0));

        return (float) returnAmount.toInt() / totalAmount.toInt();
    }
}
