package lotto.view;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumbers;

import java.util.List;

public class RequestAssembler {
    static WinningRequestDto assembleWinningRequest(LottoNumbers lottoNumbers, int bonusNumber) {
        return new WinningRequestDto(lottoNumbers, bonusNumber);
    }

    static LottoMachineDto assembleLottoMachineDto(LottoMoney lottoMoney,
                                                   int manualCount, List<LottoNumbers> manualLottoNumbers) {
        return new LottoMachineDto(lottoMoney, manualCount, manualLottoNumbers);
    }

}
