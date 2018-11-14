package lotto;

import static lotto.LottoCommonUtil.ConvertMoneyFromString;

public class LottoInit {
    private final static String DIVISOR = "1_000";
    private int cost;
    private int count;


    public LottoInit(int cost) {
        this.cost = cost;
        this.count = cost / ConvertMoneyFromString(DIVISOR);
    }

    public int getCount() {
        return this.count;
    }

    public int getCost() {
        return this.cost;
    }

}
