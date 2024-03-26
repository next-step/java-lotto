package domain;

import java.util.*;

public class LottoNumber {

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

    public static LottoNumber random(Random random) {
        return new LottoNumber(values.get(random.nextInt(45)));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
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
}
