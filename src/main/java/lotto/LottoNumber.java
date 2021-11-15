package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    public static final String INVALID_RANGE_ERROR_MESSAGE = format("%s ~ %s 의 값만 사용가능합니다.", MIN_NUMBER, MAX_NUMBER);
    private static final Map<Integer, LottoNumber> CACHED_LOTTO_NUMBERS = initCachedLottoNumbers();

    private static  Map<Integer, LottoNumber> initCachedLottoNumbers() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), LottoNumber::new));
    }

    private final int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    public static LottoNumber from(int number) {
        checkExists(number);
        return CACHED_LOTTO_NUMBERS.get(number);
    }

    private static void checkExists(int number) {
        if (!CACHED_LOTTO_NUMBERS.containsKey(number)) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    public static List<LottoNumber> listOf(int size, ShuffleStrategy shuffleStrategy) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(CACHED_LOTTO_NUMBERS.values());
        shuffleStrategy.shuffle(lottoNumbers);
        return limitFromStart(lottoNumbers, size);
    }

    private static List<LottoNumber> limitFromStart(List<LottoNumber> lottoNumbers, int closedEndIndex) {
        return lottoNumbers.stream()
                .limit(closedEndIndex)
                .collect(toList());
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
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
}
