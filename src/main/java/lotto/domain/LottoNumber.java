package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final String NOT_NUMBER_STRING_NOT_ALLOW_MESSAGE = "숫자가 아닌 문자열은 허용되지 않습니다.";
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final List<Integer> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private final int lottoNumber;

    public static LottoNumber ofRandom() {
        Collections.shuffle(LOTTO_NUMBERS);

        return new LottoNumber(LOTTO_NUMBERS.stream()
                .limit(1)
                .collect(Collectors.toList())
                .get(0));
    }

    public LottoNumber(String string) {
        this(toInt(string));
    }

    protected LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
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
