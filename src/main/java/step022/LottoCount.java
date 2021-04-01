package step022;

import static step022.LottoConfig.LOTTO_PRICE;

public class LottoCount {
    private int count = 0;

    public LottoCount() {};

    public LottoCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void calculationCount(int money) {
        count = money / LOTTO_PRICE;
    }
}
