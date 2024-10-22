package lotto.domain;

import java.math.BigDecimal;

public class LottoCount {
    public static final int UNIT_AMOUNT = 1000;

    private int totalLottoCount;
    private int manualLottoCount;

    public LottoCount(int totalPayment) {
        this(totalPayment, 0);
    }

    public LottoCount(int totalPayment, int manualLottoCount) {
        if (totalPayment % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException("구매 금액이 잘 못 입력되었습니다.");
        }
        this.totalLottoCount = totalPayment / UNIT_AMOUNT;

        if (manualLottoCount > totalLottoCount) {
            throw new IllegalArgumentException("구매 가능 건수를 초과하였습니다.");
        }
        this.manualLottoCount = manualLottoCount;
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

    public boolean isAuto() {
        return totalLottoCount == getAutoLottoCount();
    }

    public boolean isManual() {
        return totalLottoCount == manualLottoCount;
    }

    public boolean isMix() {
        return manualLottoCount>0 && getAutoLottoCount()>0;
    }

    public BigDecimal getTotalPaymentAmount() {
        return new BigDecimal(UNIT_AMOUNT).multiply(BigDecimal.valueOf(totalLottoCount));
    }

    public LottoNumberGenerator getLottoNumberGenerator() {
        if (isMix()) {
            return new MixLottoNumberGenerator(this);
        }
        if (isAuto()) {
            return new AutoLottoNumberGenerator(getAutoLottoCount());
        }
        return new ManualLottoNumberGenerator(manualLottoCount);
    }
}
