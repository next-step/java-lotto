package lotto.domain;

import java.util.*;

public class LottoNumber {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
            new LottoNumber(6), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10),
            new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15),
            new LottoNumber(16), new LottoNumber(17), new LottoNumber(18), new LottoNumber(19), new LottoNumber(20),
            new LottoNumber(21), new LottoNumber(22), new LottoNumber(23), new LottoNumber(24), new LottoNumber(25),
            new LottoNumber(26), new LottoNumber(27), new LottoNumber(28), new LottoNumber(29), new LottoNumber(30),
            new LottoNumber(31), new LottoNumber(32), new LottoNumber(33), new LottoNumber(34), new LottoNumber(35),
            new LottoNumber(36), new LottoNumber(37), new LottoNumber(38), new LottoNumber(39), new LottoNumber(40),
            new LottoNumber(41), new LottoNumber(42), new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)
    );

    private final int number;

    private LottoNumber(int number) {
        validateNumber(number);

        this.number = number;
    }

    private static void validateNumber(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1보다 작거나 45보다 클 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber valueOf(int value) {
        validateNumber(value);
        Collections.sort(lottoNumbers, Comparator.comparingInt(LottoNumber::getNumber));
        return lottoNumbers.get(toIndex(value));
    }

    private static int toIndex(int value) {
        return value - ONE;
    }

    public static LottoNumber peek() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.get(ZERO);
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
    public String toString() {
        return Integer.toString(number);
    }
}
