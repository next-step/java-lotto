package lotto.domain;

public class LottoCount {
    private int lottoCount;
    private int manualLottoCount;

    public LottoCount(int lottoCount, int manualLottoCount) {
        checkLottoCount(lottoCount, manualLottoCount);
        this.lottoCount = lottoCount;
        this.manualLottoCount = manualLottoCount;
    }

    public void checkLottoCount(int lottoCount, int manualLottoCount) {
        if (lottoCount < manualLottoCount)
            throw new IllegalArgumentException("수동으로 구매하는 로또 수가 구매 금액보다 크면 안됩니다.");
    }

    public int getAutoLottoCount() {
        return this.lottoCount - this.manualLottoCount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
    
}
