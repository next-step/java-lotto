package step2.model;

import static step2.model.LottoValidator.*;

public class LottoCount {
    private final int totalLottoCount;
    private final int manualLottoCount;
    private final int autoLottoCount;

    private static final int MIN_LOTTO_COUNT = 0;

    public LottoCount(PurchaseAmount purchaseAmount, String manualLottoCount) {
        isBlank(manualLottoCount);
        isDigit(manualLottoCount);
        isValidCount(purchaseAmount, manualLottoCount);
        this.totalLottoCount = calcLottoCount(purchaseAmount);
        this.manualLottoCount = Integer.parseInt(manualLottoCount);
        this.autoLottoCount = calcAutoLottoCount(manualLottoCount);
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }



    private void isValidCount(PurchaseAmount purchaseAmount, String lottoCount) {
        int maxLottoCount = calcLottoCount(purchaseAmount);
        int manualLottoCount = Integer.parseInt(lottoCount);
        if ( manualLottoCount < MIN_LOTTO_COUNT || manualLottoCount > maxLottoCount) {
            throw new IllegalArgumentException("구매할 로또수를 다시 확인해주세요. 최소 " + MIN_LOTTO_COUNT
                    + " ~ 최대 " + maxLottoCount + "개 까지 구매 가능합니다.");
        }
    }

    private int calcLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getLottoCount();
    }

    public int calcAutoLottoCount(String manualLottoCount) {
        return totalLottoCount - Integer.parseInt(manualLottoCount);
    }

    public boolean isEqualsManualCount(int size) {
       return manualLottoCount == size;
    }


}

