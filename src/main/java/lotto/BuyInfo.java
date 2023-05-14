package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyInfo {

    private static final int LOTTO_PRICE = 1000;
    private int amount;
    private int totalLottoCount;
    private int manuallyLottoCount;

    public void saveAmount(int amount) {
        int totalCount = amount / LOTTO_PRICE;
        this.amount = totalCount * LOTTO_PRICE;
    }

    public void saveManuallyLottoCount(int manuallyLottoCount) {
        this.manuallyLottoCount = manuallyLottoCount;
        int totalManuallyAmount = LOTTO_PRICE * manuallyLottoCount;
        this.totalLottoCount = (amount - totalManuallyAmount) / LOTTO_PRICE;
    }

    public int getTotalLottoCount() {
        return totalLottoCount;
    }

    public int getManuallyLottoCount() {
        return manuallyLottoCount;
    }

    public BigDecimal getRateOfReturn(int winningAmount) {
        if (winningAmount == 0) return new BigDecimal(0);
        return BigDecimal.valueOf(winningAmount).divide(BigDecimal.valueOf(amount), 2, RoundingMode.CEILING);
    }


}
