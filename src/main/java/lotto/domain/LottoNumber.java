package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45 이하여야 합니다.");
        }
        this.number = number;
    }

    private static boolean isInvalidNumber(int number) {
        return number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER;
    }

    public static List<Integer> getRandomLottoNumberList() {
        List<Integer> AllNumbers = IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(AllNumbers);
        return AllNumbers;
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
        return Integer.toString(this.number);
    }
}
