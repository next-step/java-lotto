package lotto.domain;

public class LottoCount {

    private final int lottoCount;

    private LottoCount(int count) {
        this.lottoCount = count;
    }

    public static LottoCount from(Money money) {
        int count = money.getCount();
        return new LottoCount(count);
    }

    public int count() {
        return lottoCount;
    }
}
