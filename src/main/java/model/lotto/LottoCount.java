package model.lotto;

public class LottoCount {
    private static final int LOTTO_PRICE = 1000;
    private final int totalCount;
    private final int manualCount;

    public LottoCount(int payAmount, int manualCount) {
        this.totalCount = getTotalCount(payAmount);
        this.manualCount = manualCount;
        checkLottoCountValidation();
    }

    private void checkLottoCountValidation() {
        if (totalCount < manualCount) {
            throw new IllegalArgumentException("수동으로 구매한 개수는 총 구매 개수를 초과할 수 없습니다.");
        }
    }

    public int getAutoCount() {
        return totalCount - manualCount;
    }

    private int getTotalCount(int payAmount) {
        return payAmount / LOTTO_PRICE;
    }

    public int getManualCount(){
        return manualCount;
    }
}
