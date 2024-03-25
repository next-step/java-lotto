package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        if (!isLottoNumber(number)) {
            throw new IllegalArgumentException("로또숫자는 1-45 사이의 수만 가능합니다.");
        }
        this.number = number;
    }

    public LottoNumber(String input) {
        this(toInt(input));
    }

    private static int toInt(String input) {
        if (hasNoInput(input)) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }

        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력할 수 있습니다.");
        }

        return number;
    }

    private static boolean hasNoInput(String input) {
        return input == null || input.isBlank();
    }

    private boolean isLottoNumber(int number) {
        return number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }


    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
