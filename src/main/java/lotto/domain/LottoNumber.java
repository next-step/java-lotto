package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    final private int number;

    public LottoNumber(int number) {
        if (!isValidLottoNumber(number)) {
            throw new IllegalArgumentException("유효하지 않은 로또 번호 입니다.");
        }

        this.number = number;
    }

    public static List<LottoNumber> createLottoNumbers(int...args) {
        return Arrays.stream(args).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

    private boolean isValidLottoNumber(int number) {
        return number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER;
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
