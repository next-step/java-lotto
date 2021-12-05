package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "입력 값의 범위 맞지 않습니다.";
    private static final String EMPTY_EXCEPTION_MESSAGE = "입력 값은 빈 값 일 수 없습니다.";
    private static final List<LottoNumber> oneThroughFourthFive = new ArrayList<>();

    static {
        for (int i = MIN; i <= MAX; i++) {
            oneThroughFourthFive.add(new LottoNumber(i));
        }
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    private static LottoNumber cachedLottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
        return oneThroughFourthFive.get(number - 1);
    }

    public static LottoNumber of(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }

        return of(Integer.parseInt(input));
    }

    public static LottoNumber of(int value) {
        return cachedLottoNumber(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }
}
