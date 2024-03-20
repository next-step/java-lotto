package lotto.domain;

public class LottoCount {
    private static final Integer PRICE = 1000;
    private final int lottoCount;

    public LottoCount(int money) {
        this.lottoCount = money / PRICE;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
