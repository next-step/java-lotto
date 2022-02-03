package lotto.util;

public class LottoGenerator {

    private final static int LOTTO_PRICE = 1000;

    public int getLottoQuantity(int purchasePrice) {
        if (isLowerThanLeastPrice(purchasePrice)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
        }
        return purchasePrice / LOTTO_PRICE;
    }

    private boolean isLowerThanLeastPrice(int price) {
        return price < LOTTO_PRICE;
    }
}
