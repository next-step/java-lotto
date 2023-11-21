package lotto.domain.lotto;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> CACHED_LOTTO_NUMBERS = initializeCachedLottoNumbers();

    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 45;

    private static final String NUMBER_ERROR_MESSAGE = String.format("로또 번호는 %s ~ %s 사이의 숫자이어야 합니다.", NUMBER_MIN, NUMBER_MAX);

    private final int lottoNumber;

    private LottoNumber(int number) {
        this.lottoNumber = number;
    }

    public static LottoNumber of(Integer number) {
        return Objects.requireNonNull(CACHED_LOTTO_NUMBERS.get(number), NUMBER_ERROR_MESSAGE);
    }


    private static Map<Integer, LottoNumber> initializeCachedLottoNumbers() {
        return newLottoNumbers(Collectors.toMap(
                number -> number,
                LottoNumber::new
        ));
    }

    public static <T> T newLottoNumbers(Collector<Integer, ?, T> collector) {
        return IntStream.rangeClosed(LottoNumber.NUMBER_MIN, LottoNumber.NUMBER_MAX)
                .boxed()
                .collect(collector);
    }

    public int value() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
