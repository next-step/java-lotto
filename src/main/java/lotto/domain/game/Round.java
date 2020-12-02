package lotto.domain.game;

import java.util.Objects;

/**
 * Created By mand2 on 2020-12-02.
 */
public class Round {

    private final int round;

    public static final int ZERO = 0;

    public static final String MESSAGE_NON_NULL = "빈칸을 입력할 수 없습니다.";
    public static final String MESSAGE_NUMBER = "정수형으로만 입력해주세요.";
    public static final String MESSAGE_NUMBER_POSITIVE = "음수로 입력할 수 없습니다.";

    private Round(int round) {
        this.round = round;
    }

    public static Round from(String inputRound) {
        int round = validate(inputRound);
        return new Round(round);
    }

    public static Round from(int inputRound) {
        checkPositive(inputRound);
        return new Round(inputRound);
    }

    public int getRound() {
        return this.round;
    }

    private static int validate(String before) {
        checkNull(before);
        int number = getNumber(before);
        checkPositive(number);
        return number;
    }

    private static void checkNull(String before) {
        if (Objects.isNull(before) || before.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_NON_NULL);
        }
    }

    private static int getNumber(String before) {
        try {
            return Integer.valueOf(before);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_NUMBER);
        }
    }

    private static void checkPositive(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException(MESSAGE_NUMBER_POSITIVE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return getRound() == round1.getRound();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRound());
    }
}
