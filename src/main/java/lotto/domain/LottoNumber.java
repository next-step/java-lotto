package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = initializeLottoNumbers();
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        validateRange(lottoNumber);
        return LOTTO_NUMBERS.get(lottoNumber);
    }

    private static Map<Integer, LottoNumber> initializeLottoNumbers() {
        Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(number -> lottoNumbers.put(number, new LottoNumber(number)));
        return lottoNumbers;
    }

    private static void validateRange(int lottoNumber) {
        if (!isInRange(lottoNumber)) {
            throw new IllegalArgumentException(
                    String.format("로또 번호는 %d~%d 사이여야 합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    private static boolean isInRange(int lottoNumber) {
        return lottoNumber >= MIN_LOTTO_NUMBER && lottoNumber <= MAX_LOTTO_NUMBER;
    }

    public int getLottoNumber() {
        return lottoNumber;
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
