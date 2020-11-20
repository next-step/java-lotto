package step2.domain;

import step2.Rank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static step2.domain.LotteryAgent.PRICE_LOTTERY;

public class MatchResult {

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

    public Map<Rank, Integer> getAllResult() {
        return Collections.unmodifiableMap(result);
    }

    public int getMatchResult(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public float getRateOfReturn() {
        return getTotalAmount().map(this::calculateRate) //
                .orElse(0f);
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

    private Optional<Money> getTotalAmount() {
        return result.values() //
                .stream() //
                .map(PRICE_LOTTERY::multiply) //
                .reduce(Money::add);
    }

    private float calculateRate(Money totalAmount) {
        return (float) getReturnAmount().toInt() / totalAmount.toInt();
    }
}
