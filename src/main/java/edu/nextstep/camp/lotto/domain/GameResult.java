package edu.nextstep.camp.lotto.domain;

import java.util.Objects;

public class GameResult {
    private static final int FIRST_PRIZE = 2000000000;
    private static final int SECOND_PRIZE = 1500000;
    private static final int THIRD_PRIZE = 50000;
    private static final int FOURTH_PRIZE = 5000;

    private final int amountOfFirst;
    private final int amountOfSecond;
    private final int amountOfThird;
    private final int amountOfFourth;

    public GameResult(int amountOfFirst, int amountOfSecond, int amountOfThird, int amountOfFourth) {
        this.amountOfFirst = amountOfFirst;
        this.amountOfSecond = amountOfSecond;
        this.amountOfThird = amountOfThird;
        this.amountOfFourth = amountOfFourth;
    }


    public static GameResult of(int firstPlace, int secondPlace, int thirdPlace, int fourthPlace) {
        if (firstPlace < 0 || secondPlace < 0 || thirdPlace < 0 || fourthPlace < 0) {
            throw new IllegalArgumentException("invalid input: each amounts must not be negative");
        }

        return new GameResult(firstPlace, secondPlace, thirdPlace, fourthPlace);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return amountOfFirst == that.amountOfFirst &&
                amountOfSecond == that.amountOfSecond &&
                amountOfThird == that.amountOfThird &&
                amountOfFourth == that.amountOfFourth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountOfFirst, amountOfSecond, amountOfThird, amountOfFourth);
    }

    public int totalPrize() {
        return amountOfFirst * FIRST_PRIZE
                + amountOfSecond * SECOND_PRIZE
                + amountOfThird * THIRD_PRIZE
                + amountOfFourth * FOURTH_PRIZE;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "first=" + amountOfFirst +
                ", second=" + amountOfSecond +
                ", third=" + amountOfThird +
                ", fourth=" + amountOfFourth +
                '}';
    }
}
