package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_RANGE = 1;
    public static final int LOTTO_MAX_RANGE = 45;
    private static final Map<Integer, LottoNumber> numbers = new HashMap<>();
    private final int number;

    static {
        for (int count = LOTTO_MIN_RANGE; count <= LOTTO_MAX_RANGE; count++) {
            numbers.put(count, new LottoNumber(count));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(numbers.get(number))
                .orElseThrow(() -> new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다. 입력하신 번호는 " + number + "입니다."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

}
