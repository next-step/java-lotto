package src.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameNumber {

    private static final int MIN_NUMBER_OF_GAME = 1;

    private static final int MAX_NUMBER_OF_GAME = 45;

    private static final List<GameNumber> allGameNumbers = new ArrayList<>(MAX_NUMBER_OF_GAME);

    static {
        for (int idx = MIN_NUMBER_OF_GAME; idx <= MAX_NUMBER_OF_GAME; idx++) {
            allGameNumbers.add(new GameNumber(idx));
        }
    }

    private final int value;

    private GameNumber(int value) {
        this.value = value;
    }

    public static GameNumber of(int number) {
        checkNumber(number);
        return new GameNumber(number);
    }

    private static void checkNumber(int number) {
        if (number < MIN_NUMBER_OF_GAME || number > MAX_NUMBER_OF_GAME) {
            throw new IllegalArgumentException("게임 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
        }
    }

    public static List<GameNumber> gameNumbers() {
        return new ArrayList<>(allGameNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GameNumber that = (GameNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
