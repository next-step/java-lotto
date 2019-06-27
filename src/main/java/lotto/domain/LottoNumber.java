package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private static final Map<Integer, LottoNumber> lottoNos = new HashMap<>();

    static {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            lottoNos.put(i, new LottoNumber(i));
        }
    }

    private final int no;

    private LottoNumber(int no) {
        if (no < LOTTO_NUMBER_MIN || no > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호의 범위를 벗어났습니다.");
        }

        this.no = no;
    }

    static LottoNumber of(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException();
        }

        return of(Integer.parseInt(value.trim()));
    }

    static LottoNumber of(int number) {
        return Optional.ofNullable(lottoNos.get(number))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "no=" + no +
                '}';
    }
}
