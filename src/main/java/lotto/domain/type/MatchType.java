package lotto.domain.type;

import java.util.function.Function;

public enum MatchType {
    THREE(3, 5000, (quantity) -> quantity * 5000),
    FOUR(4, 50000, (quantity) -> quantity * 50000),
    FIVE(5, 1500000, (quantity) -> quantity * 1500000),
    SIX(6, 2000000000, (quantity) -> quantity * 2000000000);

    private int matchCount;
    private int reward;
    private Function<Integer, Integer> prize;
    MatchType(int matchCount, int reward, Function<Integer, Integer> prize) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.prize = prize;
    }

    public int prize(int quantity) {
        return this.prize.apply(quantity);
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int reward() {
        return this.reward;
    }
}
