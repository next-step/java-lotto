package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNo {
    private static final int LOTTO_MAX_COUNT = 46;

    private static final Map<Integer, LottoNo> number = new HashMap<>();
    private Integer no;

    static {
        for (int i = 1; i < LOTTO_MAX_COUNT; i++) {
            number.put(i, new LottoNo(i));
        }
    }

    private LottoNo(int number) {
        if (number < 1 || number > LOTTO_MAX_COUNT) {
            throw new IllegalArgumentException();
        }
        this.no = number;
    }

    static LottoNo of(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException();
        }

        return of(Integer.parseInt(value.trim()));
    }

    static LottoNo of(int digit) {
        return Optional.ofNullable(number.get(digit))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNo)) return false;
        LottoNo lottoNo = (LottoNo) o;
        return Objects.equals(number, lottoNo.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return "" + no;
    }
}
