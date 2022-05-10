package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final String NOT_NUMBER_STRING_NOT_ALLOW_MESSAGE = "숫자가 아닌 문자열은 허용되지 않습니다.";
    private static final String INVALID_NUMBER_MESSAGE = "유효하지 않은 숫자입니다.";
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private final int lottoNumber;

    public LottoNumber(String string) {
        this(toInt(string));
    }

    protected LottoNumber(int lottoNumber) {
        checkInvalid(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber ofRandom() {
        Collections.shuffle(LOTTO_NUMBERS);

        return LOTTO_NUMBERS.stream()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static int toInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_STRING_NOT_ALLOW_MESSAGE);
        }
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    private void checkInvalid(int lottoNumber) {
        if (lottoNumber < START_LOTTO_NUMBER || lottoNumber > END_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
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
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
