package domain;

import java.util.Objects;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(PickNumberStrategy pickNumberStrategy) {
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
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
