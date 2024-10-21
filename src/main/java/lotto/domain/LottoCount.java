package lotto.domain;

import java.math.BigDecimal;

public class LottoCount {
    public static final int UNIT_AMOUNT = 1000;

    private int totalLottoCount;
    private int manualLottoCount;

    public LottoCount(int totalPayment) {
        if (totalPayment % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException("구매 금액이 잘 못 입력되었습니다.");
        }
        this.totalLottoCount = totalPayment / UNIT_AMOUNT;
    }

    public int getTotalLottoCount() {
        return totalLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return totalLottoCount - manualLottoCount;
    }

    public void addManualLottoCount(int count) {
        manualLottoCount += count;
    }

    public BigDecimal getTotalPaymentAmount() {
        return new BigDecimal(UNIT_AMOUNT).multiply(BigDecimal.valueOf(totalLottoCount));
    }

}
