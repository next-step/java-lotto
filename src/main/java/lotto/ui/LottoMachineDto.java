package lotto.ui;

import lotto.domain.machine.LottoMoney;
import lotto.domain.lotto.LottoNumbers;

import java.util.List;

public class LottoMachineDto {
    private LottoMoney lottoMoney;
    private List<LottoNumbers> lottoNumbers;

    public LottoMachineDto(LottoMoney lottoMoney, List<LottoNumbers> lottoNumbers) {
        this.lottoMoney = lottoMoney;
        this.lottoNumbers = lottoNumbers;
    }

    public LottoMoney getLottoMoney() {
        return lottoMoney;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }
}
