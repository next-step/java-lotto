package lotto.ui;

import lotto.domain.machine.LottoMoney;
import lotto.domain.lotto.LottoNumbers;

import java.util.List;

public class RequestAssembler {
    static WinningRequestDto assembleWinningRequest(LottoNumbers lottoNumbers, int bonusNumber) {
        return new WinningRequestDto(lottoNumbers, bonusNumber);
    }

    static LottoMachineDto assembleLottoMachineDto(LottoMoney lottoMoney, int i, List<LottoNumbers> manualLottoNumbers) {
        return new LottoMachineDto(lottoMoney, manualLottoNumbers);
    }

    static LottoGameDto assembleLottoGameDto(LottoMoney lottoMoney, List<LottoNumbers> manualLottoNumbers) {
        return new LottoGameDto(lottoMoney, manualLottoNumbers);
    }

}
