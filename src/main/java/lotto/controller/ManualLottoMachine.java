package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoMachine implements LottoGenerator {
    private LottoCount manualCount;
    private LottoCount inputCount;
    private List<LottoNumbers> lottoNumbersList;

    public ManualLottoMachine(LottoCount manualCount) {
        this.manualCount = manualCount;
        this.inputCount = new LottoCount(0);
        this.lottoNumbersList = new ArrayList<>();
    }

    public boolean isManualNumberInputEnd() {
        return this.inputCount.equals(this.manualCount);
    }

    public void getManualLottoNumbers(String lottoNumbers) {
        this.inputCount = this.inputCount.increase();
        lottoNumbersList.add(new LottoNumbers(lottoNumbers));
    }

    @Override
    public Lotto generate() {
        return new Lotto(lottoNumbersList);
    }
}
