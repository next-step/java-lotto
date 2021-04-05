package step02;

import static step02.LottoConfig.LOTTO_PRICE;

public class LottoCount {
    private int count = 0;

    public LottoCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public static int calculationCount(int money) {
        return money / LOTTO_PRICE;
    }
}
