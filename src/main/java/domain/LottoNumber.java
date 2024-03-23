package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static List<Integer> values;

    static {
        values = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            values.add(i);
        }
    }

    private final int value;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < 1 || 45 < lottoNumber) {
            throw new IllegalArgumentException("1~45 사이의 숫자만 가능합니다.");
        }
        this.value = lottoNumber;
    }

    public static LottoNumber random() {
        List<Integer> numbers = new ArrayList<>(values);
        Collections.shuffle(numbers);
        return new LottoNumber(numbers.get(0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }
}
