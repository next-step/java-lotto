package lotto.type;

import java.util.Arrays;
import java.util.function.Function;

public enum RankType {
    NO_RANK(0, condition -> condition < 3 || condition > 6),
    RANK1(2_000_000_000, condition -> condition == 6),
    RANK2(1_500_000, condition -> condition == 5),
    RANK3(50_000, condition -> condition == 4),
    RANK4(5_000, condition -> condition == 3);

    private int reward;
    private Function<Integer, Boolean> expression;

    RankType(int reward, Function<Integer, Boolean> expression) {
        this.reward = reward;
        this.expression = expression;
    }

    public int getTotalReward(int count) {
        return this.reward * count;
    }

    public static RankType getRank(int condition) {
        return Arrays.stream(RankType.values())
                .filter(type -> type.expression.apply(condition))
                .findAny().get();
    }
}
