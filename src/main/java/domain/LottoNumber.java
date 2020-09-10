package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private static final Random random = new Random();
    private static final List<LottoNumber> cached = IntStream.rangeClosed(1, 45)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("1 이상 45 이하의 값을 입력해주세요.");
        }
    }

    public static LottoNumber getRandomLottoNumber() {
        int randomNumber = random.nextInt(LOTTO_NUMBER_MAX) + 1;
        return getLottoNumber(randomNumber);
    }

    public static LottoNumber getLottoNumber(int number) {
        int index = number - 1;
        return cached.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return number == lottoNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
