package lottogame.domain;

import java.util.Objects;

public class LottoBonus {

    private final LottoNumber lottoNumber;

    public LottoBonus(int lottoNumber) {
        this.lottoNumber = LottoNumber.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoBonus)) {
            return false;
        }
        LottoBonus that = (LottoBonus) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return "LottoBonus{" +
            "lottoNumber=" + lottoNumber +
            '}';
    }
}
