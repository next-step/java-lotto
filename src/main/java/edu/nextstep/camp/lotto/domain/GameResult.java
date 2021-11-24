package edu.nextstep.camp.lotto.domain;

import java.util.Objects;

public class GameResult {
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

    public Prize totalPrize() {
        return Prize.ofFirstPlace(amountOfFirst)
                .add(Prize.ofSecondPlace(amountOfSecond))
                .add(Prize.ofThirdPlace(amountOfThird))
                .add(Prize.ofFourthPlace(amountOfFourth));
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

    public int firstPlace() {
        return amountOfFirst;
    }

    public int secondPlace() {
        return amountOfSecond;
    }

    public int thirdPlace() {
        return amountOfThird;
    }

    public int fourthPlace() {
        return amountOfFourth;
    }
}
