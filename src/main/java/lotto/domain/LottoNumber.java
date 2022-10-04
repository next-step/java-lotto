package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();
    private static final String LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1 이상이어야 합니다.";
    private static final String INPUT_EXCEPTION_MESSAGE = "숫자만 입력해주세요.";

    private final int number;

    static {
        IntStream.range(MIN, MAX)
                .forEach(i -> LOTTO_NUMBERS.add(new LottoNumber(i)));
    }


    public static LottoNumber of(String number) {
        try {
            return new LottoNumber(Integer.parseInt(number.strip()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(LOTTO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof LottoNumber)) {
            return false;
        }

        LottoNumber lottoNumber = (LottoNumber) o;
        return this.number == lottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return number - other.number;
    }
}
