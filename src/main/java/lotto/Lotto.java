package lotto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    public static final String SYMBOL_COMMA = ",";
    private static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        this.lotto = lotto;
    }

    public static Lotto ofComma(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException();
        }

        String[] values = text.split(SYMBOL_COMMA);
        Set<LottoNumber> lotto = new HashSet<>();
        for (String value : values) {
            lotto.add(LottoNumber.of(value));
        }
        return new Lotto(lotto);
    }

    public static Lotto of(Integer... numbers) {
        Set<LottoNumber> lotto = new HashSet<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }
}
