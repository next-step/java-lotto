package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final List<LottoNumber> ALL_NUMBERS = new ArrayList<>();
    private static final int MIN = 1;
    private static final int MAX = 45;

    static {
        for (int i = MIN; i <= MAX; i++) {
            ALL_NUMBERS.add(new LottoNumber(i));
        }
    }

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
        validate();
    }

    public int getNumber() {
        return number;
    }

    private void validate() {
        if (MIN > number || number > MAX) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자여야 합니다.");
        }
    }

    public static List<LottoNumber> getAllNumbers() {
        return new ArrayList<>(ALL_NUMBERS);
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
        return Objects.hashCode(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }
}
