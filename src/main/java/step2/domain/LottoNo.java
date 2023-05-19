package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class LottoNo {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static Map<Integer, LottoNo> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
                .forEach(i -> lottoNumberCache.put(i, new LottoNo(i)));
    }

    private int number;

    private LottoNo(int number) {
        this.number = number;
    }

    public static LottoNo of(int number) {
        Optional<LottoNo> lottoNo = Optional.ofNullable(lottoNumberCache.get(number));
        return lottoNo.orElseThrow(() -> new IllegalArgumentException("잘못 입력하셨습니다."));
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
