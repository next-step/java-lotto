package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class LottoBuyDetails {
    public static final int UNIT_AMOUNT = 1000;

    private int totalLottoCount;
    private ManualBuyDetails manualBuyDetails;

    public LottoBuyDetails(int totalPayment) {
        this(totalPayment, null);
    }

    public LottoBuyDetails(int totalPayment, ManualBuyDetails manualBuyDetails) {

        if (totalPayment % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException("구매 금액이 잘 못 입력되었습니다.");
        }
        this.totalLottoCount = totalPayment / UNIT_AMOUNT;

        if (manualBuyDetails == null) {
            return ;
        }
        if (manualBuyDetails.getCount() > totalLottoCount) {
            throw new IllegalArgumentException("구매 가능 건수를 초과하였습니다.");
        }
        this.manualBuyDetails = manualBuyDetails;
    }
    public int getTotalLottoCount() {
        return totalLottoCount;
    }

    public int getManualLottoCount() {
        if (manualBuyDetails == null) {
            return 0 ;
        }
        return manualBuyDetails.getCount();
    }

    public int getAutoLottoCount() {
        if (manualBuyDetails == null) {
            return totalLottoCount;
        }
        return totalLottoCount - manualBuyDetails.getCount();
    }

    public boolean isAuto() {
        return manualBuyDetails == null || manualBuyDetails.getCount() ==0 ;
    }

    public boolean isManual() {
        if (manualBuyDetails == null) {
            return false;
        }
        return manualBuyDetails.getCount() == totalLottoCount;
    }

    public boolean isMix() {
        if (manualBuyDetails == null) {
            return false;
        }
        return manualBuyDetails.getCount() > 0 && getAutoLottoCount() > 0;
    }

    public BigDecimal getTotalPaymentAmount() {
        return new BigDecimal(UNIT_AMOUNT).multiply(BigDecimal.valueOf(totalLottoCount));
    }

    public ManualBuyDetails getManualBuyDetails() {
        return manualBuyDetails;
    }

}
