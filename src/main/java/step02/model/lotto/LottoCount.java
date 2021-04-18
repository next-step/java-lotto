package step02.model.lotto;

import step02.utils.Validation;

public class LottoCount {
    private LottoTotalCount totalCount;
    private LottoManualCount lottoManualCount;
    private LottoAutomaticCount lottoAutomaticCount;

    public LottoCount(){}

    public void setTotalCount(int count) {
        this.totalCount = new LottoTotalCount(count);
    }

    public int getTotalCount() {
        return totalCount.getTotalCount();
    }

    public void setLottoManualCount(int manualCount) {
        Validation.checkMakeableLotto(totalCount.getTotalCount(), manualCount);
        this.lottoManualCount = new LottoManualCount(manualCount);
    }

    public void setLottoAutomaticCount(int automaticCount) {
        Validation.checkMakeableLotto(totalCount.getTotalCount(), automaticCount);
        this.lottoAutomaticCount = new LottoAutomaticCount(automaticCount);
    }

    public int getManualCount() {
        return lottoManualCount.getManualCount();
    }

    public int getAutomaticCount() {
        return lottoAutomaticCount.getAutomaticCount();
    }

    public static int calculationRemain(int totalCount, int count) {
        return totalCount -= count;
    }
}
