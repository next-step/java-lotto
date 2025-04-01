package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toUnmodifiableMap(number -> number, LottoNumber::new));

    private final int number;

    private LottoNumber(int number) {
        validateInputs(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateInputs(number);
        return LOTTO_NUMBER_CACHE.get(number);
    }

    public static List<LottoNumber> from(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> pickRandomLottoNumbers(int count) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LOTTO_NUMBER_CACHE.values());
        Collections.shuffle(lottoNumbers);

        return lottoNumbers.subList(0, count);
    }

    private static void validateInputs(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            String messageFormat = "로또 번호는 %d ~ %d 사이 정수만 가능합니다.";
            throw new IllegalArgumentException(String.format(messageFormat, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LottoNumber that = (LottoNumber) object;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
