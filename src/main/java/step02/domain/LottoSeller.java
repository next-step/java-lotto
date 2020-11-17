package step02.domain;

import java.util.Objects;

public class LottoSeller {
    private final LottoPrice lottoPrice;

    private LottoSeller(LottoPrice lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public static LottoSeller of(int lottoPrice) {
        return new LottoSeller(LottoPrice.of(lottoPrice));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoSeller that = (LottoSeller) o;
        return Objects.equals(lottoPrice, that.lottoPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrice);
    }
}
