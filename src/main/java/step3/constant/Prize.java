package step3.constant;

import java.util.stream.Stream;

public enum Prize {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 1500000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    BAD_LUCK(0,false,  0);

    private int correct;
    private boolean bonus;
    private long reward;

    Prize(int correct, boolean bonus, long reward) {
        this.correct = correct;
        this.bonus = bonus;
        this.reward = reward;
    }

    public static Prize getPrize(int number, boolean bonus) {
        return Stream.of(Prize.values())
                     .filter(prize -> prize.getCorrect() == number &&
                                      prize.isBonus() == bonus)
                     .findFirst().orElse(BAD_LUCK);
    }

    public int getCorrect() {
        return correct;
    }

    public long getReward() {
        return reward;
    }

    public boolean isBonus() {
        return bonus;
    }
}
