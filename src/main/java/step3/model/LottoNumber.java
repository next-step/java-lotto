package step3.model;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int ZERO_INDEX = 0;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String RANGE_ERROR_MESSAGE = format("로또 번호는 %d부터 %d 사이여야 합니다.", MIN, MAX);
    private static final List<LottoNumber> DEFAULT_LOTTO_NUMBERS = initDefaultLottoNumbers();

    public static List<LottoNumber> generateRandomNumbers(int listSize) {
        Collections.shuffle(DEFAULT_LOTTO_NUMBERS);
        return new ArrayList<>(DEFAULT_LOTTO_NUMBERS.subList(ZERO_INDEX, listSize));
    }

    private static List<LottoNumber> initDefaultLottoNumbers() {
        return IntStream.rangeClosed(MIN, MAX)
            .mapToObj(LottoNumber::new)
            .collect(toList());
    }

    private final int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber other = (LottoNumber) o;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
