package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNo {

    private static final Map<Integer, LottoNo> lottoNos = new HashMap<>();

    public static final int MIN = 1;
    public static final int MAX = 45;

    static {
        for (int i = MIN; i <= MAX; i++) {
            lottoNos.put(i, new LottoNo(i));
        }
    }

    private final int number;

    private LottoNo(final int number) {
        validation(number);
        this.number = number;
    }

    public static LottoNo from(final int number) {
        validation(number);
        return lottoNos.get(number);
    }

    public static boolean eqBonus(final LottoNo lottoNo, final int lottoNum) {
        return lottoNos.get(lottoNum).equals(lottoNo);
    }

    private static void validation(final int number) {
        Optional.of(number)
                .filter(num -> num >= MIN && num <= MAX)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNo no = (LottoNo) o;
        return number == no.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
    
}
