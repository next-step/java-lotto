package lotto.vo;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "입력 값의 범위 맞지 않습니다.";
    private static final String EMPTY_EXCEPTION_MESSAGE = "입력 값은 빈 값 일 수 없습니다.";

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber create(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }

        if(!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }

        int value = Integer.parseInt(input);

        return create(value);
    }

    public static LottoNumber create(int value) {
        if(value < LottoRule.START_NUMBER.getValue() || value > LottoRule.END_NUMBER.getValue()) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }

        return new LottoNumber(value);
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
}
