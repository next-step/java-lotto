package step4.constant;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Prize {

    FIRST(6, 2_000_000_000, (correct, bonus) -> correct == 6 && !bonus),
    SECOND(5,1_500_000, (correct, bonus) -> correct == 5 && bonus),
    THIRD(5, 1_500_000, (correct, bonus) -> correct == 5 && !bonus),
    FOURTH(4,50_000, (correct, bonus) -> correct == 4 && !bonus),
    FIFTH(3, 5_000, (correct, bonus) -> correct == 3 && !bonus),
    BAD_LUCK(0,  0, (correct, bonus) -> correct == 6 && !bonus);

    private final int correct;
    private final long reward;
    private final BiFunction<Integer, Boolean, Boolean> expression;

    Prize(int correct, long reward, BiFunction<Integer, Boolean, Boolean> expression) {
        this.correct = correct;
        this.reward = reward;
        this.expression = expression;
    }
    public static Prize getPrize(int number, boolean bonus) {
        return Stream.of(Prize.values())
                     .filter(p -> p.expression.apply(number, bonus))
                     .findFirst().orElse(BAD_LUCK);
    }

    public int getCorrect() {
        return correct;
    }

    public long getReward() {
        return reward;
    }
}
