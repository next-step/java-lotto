package lotto.model;

import java.util.List;

public class Manuals {
    private final List<List<Integer>> manualNumbers;
    private final LottoMoney lottoMoney;

    public Manuals(final List<List<Integer>> manualNumbers, final LottoMoney lottoMoney) {
        this.manualNumbers = manualNumbers;
        this.lottoMoney = lottoMoney;
    }

    public int getManualCount() {
        return lottoMoney.getLottoCount();
    }

    public List<List<Integer>> getManualNumbers() {
        return manualNumbers;
    }
}
