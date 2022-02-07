package lotto.domain;

public class LottoCount {

    private static final int LOTTO_PRICE = 1_000;

    private int lottoCount;

    public LottoCount(int count) {
        this.lottoCount = count / LOTTO_PRICE;
    }

    public int count() {
        return lottoCount;
    }
}
