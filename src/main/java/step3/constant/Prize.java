package step3.constant;

import static step3.domain.Winning.COUNT_BONUS;

import java.util.stream.Stream;

public enum Prize {

    FIRST(6, 2000000000),
    SECOND(5,1500000),
    THIRD(5, 1500000),
    FOURTH(4,50000),
    FIFTH(3, 5000),
    BAD_LUCK(0,  0);

    private final int correct;
    private final long reward;

    Prize(int correct, long reward) {
        this.correct = correct;
        this.reward = reward;
    }

    public static Prize getPrize(int number, boolean bonus) {
        Prize prize = Stream.of(Prize.values())
                             .filter(p -> p.getCorrect() == number)
                             .findFirst().orElse(BAD_LUCK);

        if (countBonus(prize.getCorrect())) {
            return getPrizeByBonus(bonus, prize);
        }

        return prize;
    }

    private static boolean countBonus(int correct) {
        return COUNT_BONUS == correct;
    }

    private static Prize getPrizeByBonus(boolean bonus, Prize prize) {
        if (COUNT_BONUS == prize.getCorrect() && bonus) {
            return SECOND;
        }

        return THIRD;
    }

    public int getCorrect() {
        return correct;
    }

    public long getReward() {
        return reward;
    }
}
