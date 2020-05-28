package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<Integer> LOTTO_NUMBER_LIST = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());
    private static final Random RANDOM = new Random();
    private final int number;

    private LottoNumber(int number) {
        if (!LOTTO_NUMBER_LIST.contains(number)) {
            throw new IllegalArgumentException(String.format("`number` is must be %d ~ %d", MIN_NUMBER, MAX_NUMBER));
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber generateByManual(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber generateByAuto() {
        int number = RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + 1;
        return new LottoNumber(number);
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
