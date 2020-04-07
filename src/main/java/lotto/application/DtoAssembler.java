package lotto.application;

import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.machine.LottoMoney;
import lotto.ui.WinningRequestDto;

import java.util.List;

public class DtoAssembler {
    public static WinningRequestDto assembleWinningRequest(LottoNumbers lottoNumbers, int bonusNumber) {
        return new WinningRequestDto(lottoNumbers, bonusNumber);
    }

    public static LottoRequest assembleLottoRequest(LottoMoney lottoMoney, List<LottoNumbers> manualLottoNumbers) {
        return new LottoRequest(lottoMoney, manualLottoNumbers);
    }

    public static LottoBuyResponse assembleLottoByResponse(Lottery lotteryByManual, Lottery lotteryByAuto) {
        return new LottoBuyResponse(lotteryByManual, lotteryByAuto);
    }

}
