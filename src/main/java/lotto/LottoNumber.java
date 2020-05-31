package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable {

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private int number;

    private static final List<LottoNumber> DEFAULT_LOTTO_NUMBERS;
    static {
        DEFAULT_LOTTO_NUMBERS = IntStream.range(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX + 1)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private LottoNumber(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("로또 번호가 범위에 포함되어 있지 않습니다.");
        }
        this.number = number;
    }

    public static LottoNumber of(int lottoValue) {
        return new LottoNumber(lottoValue);
    }

    public int getNumber() {
        return number;
    }


    public static List<LottoNumber> getDefaultLottoNumbers() {
        return DEFAULT_LOTTO_NUMBERS;
    }

    public static boolean isValidNumber(int number) {
        return number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(number, ((LottoNumber) o).getNumber());
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
        return String.valueOf(number);
    }
}
