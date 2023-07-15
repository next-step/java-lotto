package lotto.domain.game;

public final class LottoCount {

    private final int lottoManualCount;
    private final int lottoAutoCount;

    public LottoCount(final Payment payment, final int lottoManualCount) {
        validateLottoManualCount(payment, lottoManualCount);
        this.lottoManualCount = lottoManualCount;
        this.lottoAutoCount = calculateLottoAutoCount(payment, lottoManualCount);
    }

    private void validateLottoManualCount(Payment payment, int lottoManualCount) {
        if ((lottoManualCount * Lotto.PRICE) > payment.getMoney()) {
            throw new IllegalArgumentException("투입 금액이 부족합니다");
        }
    }

    private int calculateLottoAutoCount(Payment payment, int lottoManualCount) {
        return ((payment.getMoney() - (lottoManualCount * Lotto.PRICE)) / Lotto.PRICE );
    }

    public int getLottoManualCount() {
        return lottoManualCount;
    }

    public int getLottoAutoCount() {
        return lottoAutoCount;
    }
}
