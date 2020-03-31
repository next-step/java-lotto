package lotto.view;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumbers;

import java.util.List;

public class LottoMachineDto {
    private LottoMoney lottoMoney;
    private int manualCount;
    private List<LottoNumbers> lottoNumbers;

    public LottoMachineDto(LottoMoney lottoMoney,
                           int manualCount, List<LottoNumbers> lottoNumbers) {
        this.lottoMoney = lottoMoney;
        this.manualCount = manualCount;
        this.lottoNumbers = lottoNumbers;
    }

    public LottoMoney getLottoMoney() {
        return lottoMoney;
    }

    public int getManualCount() {
        return manualCount;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }
}
