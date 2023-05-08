package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNo {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static Map<Integer, LottoNo> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(number -> lottoNumberCache.put(number, new LottoNo(number)));
    }

    private final int number;

    private LottoNo(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNo of(int number) {
        if (!lottoNumberCache.containsKey(number)) {
            lottoNumberCache.put(number, new LottoNo(number));
        }
        return lottoNumberCache.get(number);
    }

    private void validate(int number) {
        if (number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("1보다 작은 값은 로또 번호가 될 수 없습니다.");
        }
        if (number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 45를 넘어갈 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo1 = (LottoNo) o;
        return number == lottoNo1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
