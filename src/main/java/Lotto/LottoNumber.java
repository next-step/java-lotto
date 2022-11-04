package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String INVALID_NUMBER = "유효하지 않은 로또 번호입니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> lottoNumbersMap = new HashMap<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i ++) {
            lottoNumbersMap.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumbersMap.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }

        return lottoNumber;
    }

    public static List<LottoNumber> shuffleNumbers() {
        List<LottoNumber> range = IntStream
                .range(MIN_NUMBER, MAX_NUMBER + 1)
                .boxed()
                .map(v -> LottoNumber.of(v))
                .collect(Collectors.toList());
        Collections.shuffle(range);

        return range;
    }

    public int getNumber() {
        return number;
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

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
