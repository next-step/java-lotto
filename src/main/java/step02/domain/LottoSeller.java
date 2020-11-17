package step02.domain;

import java.util.Objects;

public class LottoSeller {
    private final int perLottoPrice;

    private LottoSeller(int perLottoPrice) {
        this.perLottoPrice = perLottoPrice;
    }

    public static LottoSeller of(int perLottoPrice) {
        return new LottoSeller(perLottoPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoSeller that = (LottoSeller) o;
        return perLottoPrice == that.perLottoPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(perLottoPrice);
    }
}
