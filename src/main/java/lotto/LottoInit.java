package lotto;

import lotto.lottoView.InputView;

import static lotto.LottoCommonUtil.convertMoneyFromString;

public class LottoInit {
    private final static String DIVISOR = "1_000";
    private int cost;
    private int totalCount;
    private int manualCount;

    public LottoInit(int cost) {
        this.cost = cost;
        this.totalCount = cost / convertMoneyFromString(DIVISOR);
        this.manualCount = InputView.inputManualCount(this.totalCount);
    }

    public int getTotalCount() {
        return this.totalCount;
    }
    public int getManualCount(){
        return this.manualCount;
    }

    public int getCost() {
        return this.cost;
    }

}
