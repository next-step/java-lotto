package domain;

public class LottoGame {
    private final int lottoCount;

    public LottoGame(int purchaseAmount) {
        if (isValid(purchaseAmount)) {
            throw new IllegalArgumentException("로또 구입 금액은 0원 이상이어야 하며 1000원 단위로 가능합니다.");
        }
        this.lottoCount = purchaseAmount / 1000;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private boolean isValid(int purchaseAmount) {
        return purchaseAmount <= 0 || purchaseAmount % 1000 != 0;
    }
}
