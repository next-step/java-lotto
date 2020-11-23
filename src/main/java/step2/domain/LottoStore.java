package step2.domain;

public class LottoStore {
    final int PRICE = 1000;

    public int getPurchaseLottoCount(int purchasePrice) {
        return purchasePrice / this.PRICE;
    }
}
