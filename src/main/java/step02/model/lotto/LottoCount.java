package step02.model.lotto;

import step02.utils.Validation;

public class LottoCount {
    private LottoCountNumber totalCount;
    private LottoCountNumber lottoManualCount;
    private LottoCountNumber lottoAutomaticCount;

    public LottoCount(int count) {
        this.totalCount = new LottoCountNumber(count);
    }

    public void setLottoManualCount(int manualCount) {
        Validation.checkMakeableLotto(totalCount.getCount(), manualCount);
        this.lottoManualCount = new LottoCountNumber(manualCount);
    }

    public void setLottoAutomaticCount() {
        int manualCount = LottoCount.calculationRemain(totalCount, lottoManualCount);
        Validation.checkMakeableLotto(totalCount.getCount(), manualCount);
        this.lottoAutomaticCount = new LottoCountNumber(manualCount);
    }

    public int getManualCount() {
        return lottoManualCount.getCount();
    }

    public int getAutomaticCount() {
        return lottoAutomaticCount.getCount();
    }

    public static int calculationRemain(LottoCountNumber totalCount, LottoCountNumber count) {
        return totalCount.getCount() - count.getCount();
    }
}
