package domain;

import java.util.Objects;

public class Lotto {

    private LottoPrice lottoPrice;

    private LottoNumbers lottoNumbers;

    public Lotto(PickNumberStrategy pickNumberStrategy) {
        this.lottoPrice = new LottoPrice();
        this.lottoNumbers = new LottoNumbers(pickNumberStrategy);
    }

    public LottoNumbers getNumbers() {
        return lottoNumbers;
    }

    public static int calcPurchaseLottoCount(int purchaseAmount) {
        return LottoPrice.purchaseLottoCount(purchaseAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoPrice, lotto.lottoPrice) && Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrice, lottoNumbers);
    }
}
