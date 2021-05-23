package lotto.domain.wrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static lotto.domain.LottoGameOptions.LOTTO_NUMBERS_FROM;
import static lotto.domain.LottoGameOptions.LOTTO_NUMBERS_TO;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (!staticFactoryMap.containsKey(number)) {
            throw new IllegalArgumentException("Lotto 숫자로 유효하지 않은 숫자입니다.");
        }
        return staticFactoryMap.get(number);
    }

    private static Map<Integer, LottoNumber> staticFactoryMap = new HashMap<>();
    static {
        for (int i = LOTTO_NUMBERS_FROM; i <= LOTTO_NUMBERS_TO; ++i) {
            staticFactoryMap.put(i, new LottoNumber(i));
        }
    }

    public int number() {
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
        return Integer.toString(number);
    }


    @Override
    public int compareTo(LottoNumber that) {
        if (this.number > that.number) {
            return 1;
        }
        if (this.number == that.number) {
            return 0;
        }
        return -1;
    }
}
