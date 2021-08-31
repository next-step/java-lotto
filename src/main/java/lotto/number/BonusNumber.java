package lotto.number;

import java.util.Objects;

public class BonusNumber {
    private final LottoNumber number;

    public BonusNumber(int lottoNumber) {
        this(new LottoNumber(lottoNumber));
    }

    public BonusNumber(LottoNumber lottoNumber) {
        number = lottoNumber;
    }

    public LottoNumber value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
