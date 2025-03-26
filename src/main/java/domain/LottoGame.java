package domain;

public class LottoGame {
    private final int lottoCount;

    public LottoGame(int purchaseAmount) {
        this.lottoCount = purchaseAmount / 1000;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
