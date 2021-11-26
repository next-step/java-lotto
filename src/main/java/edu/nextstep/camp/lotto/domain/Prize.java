package edu.nextstep.camp.lotto.domain;

import java.util.Objects;

public class Prize {
    public static final Prize FIRST_PRIZE = Prize.of(2000000000);
    public static final Prize SECOND_PRIZE = Prize.of(1500000);
    public static final Prize THIRD_PRIZE = Prize.of(50000);
    public static final Prize FOURTH_PRIZE = Prize.of(5000);
    public static final Prize NO_PRIZE = Prize.of(0);

    private final long prize;

    private Prize(long prize) {
        this.prize = prize;
    }

    public static Prize of(long prize) {
        if (prize < 0) {
            throw new IllegalArgumentException("invalid input: prize can not be smaller than 0.");
        }

        return new Prize(prize);
    }

    public static Prize ofFirstPlace(int amounts) {
        return FIRST_PRIZE.multiply(amounts);
    }

    public static Prize ofSecondPlace(int amounts) {
        return SECOND_PRIZE.multiply(amounts);
    }

    public static Prize ofThirdPlace(int amounts) {
        return THIRD_PRIZE.multiply(amounts);
    }

    public static Prize ofFourthPlace(int amounts) {
        return FOURTH_PRIZE.multiply(amounts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize1 = (Prize) o;
        return prize == prize1.prize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }

    public long toLong() {
        return prize;
    }

    @Override
    public String toString() {
        return Long.toString(prize);
    }

    public Prize add(Prize that) {
        return new Prize(prize + that.prize);
    }

    public Prize multiply(long multiplier) {
        return new Prize(prize * multiplier);
    }
}
