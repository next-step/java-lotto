package lotto.domain.game;

public final class LottoCount {

    private final int manualCount;
    private final int autoCount;

    public LottoCount(final Payment payment, final int manualCount) {
        validateLottoManualCount(payment, manualCount);
        this.manualCount = manualCount;
        this.autoCount = calculateLottoAutoCount(payment, manualCount);
    }

    private void validateLottoManualCount(Payment payment, int lottoManualCount) {
        if ((lottoManualCount * Lotto.PRICE) > payment.getMoney()) {
            throw new IllegalArgumentException("투입 금액이 부족합니다");
        }
    }

    private int calculateLottoAutoCount(Payment payment, int lottoManualCount) {
        return ((payment.getMoney() - (lottoManualCount * Lotto.PRICE)) / Lotto.PRICE );
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
