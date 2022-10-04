package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();
    private static final String LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1 이상이어야 합니다.";
    private static final String NOT_FOUND_EXCEPTION_MESSAGE = "캐싱된 데이터를 찾을 수 없습니다.";
    private static final String INPUT_EXCEPTION_MESSAGE = "숫자만 입력해주세요.";

    private final int number;

    static {
        IntStream.range(MIN, MAX + 1)
                .forEach(i -> LOTTO_NUMBERS.add(new LottoNumber(i)));
    }

    public static LottoNumber of(String stringNumber) {
        int number = parseNumber(stringNumber);

        return LottoNumber.of(number);
    }

    public static LottoNumber of(int number) {
        return getLottoNumber(number);
    }

    private static LottoNumber getLottoNumber(int number) {
        return LOTTO_NUMBERS.stream()
                .filter(lottoNumber -> lottoNumber.number == number)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_EXCEPTION_MESSAGE));
    }

    private static int parseNumber(String stringNumber) {
        int number;
        try {
            number = Integer.parseInt(stringNumber.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
        return number;
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
